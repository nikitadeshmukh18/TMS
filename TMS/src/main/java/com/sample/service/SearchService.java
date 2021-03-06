package com.sample.service;

import com.sample.model.Bus;
import com.sample.model.BusStop;
import com.sample.dao.SearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sample.model.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class SearchService {

    private SearchDao searchDao;
    private BusService busService;
    private RouteService routeService;
    private BusStopService busStopService;

    public SearchService() {


    }

    @Autowired

    public SearchService(SearchDao searchDao, BusService busService, RouteService routeService,BusStopService stopService) {
        this.searchDao = searchDao;
        this.busService = busService;
        this.routeService = routeService;
        this.busStopService = stopService;
    }

    public List<BusStop> getAllStops(String src,String destination) {
        return searchDao.getSearchList(src);
    }

    public List<SearchResult> getSearchResults(String source, String destination){
        List<Integer> sourceIds =  searchDao.getSearchList(source);
        List<Integer> destinationIds = searchDao.getSearchList(destination);

        int sourceId = busStopService.getId(source);
        int destinationId = busStopService.getId(destination);

        List<Integer> final_routes= findCommonRoutes(sourceIds, destinationIds);
        Iterator it= final_routes.iterator();

        List<SearchResult> searchResults= new ArrayList<SearchResult>();
        if(it.hasNext())
        {
            do
            {
                Integer rId=(Integer)it.next();
                List<Bus> buses = busService.getBusesByRoute(rId);

                int sIndex = routeService.getStopIndex(sourceId,rId);
                int dIndex = routeService.getStopIndex(destinationId, rId);
                if (sIndex<dIndex){
                Iterator bIterator = buses.iterator();
                while (bIterator.hasNext()){
                        SearchResult result = new SearchResult();
                        result.setBusId1(((Bus) bIterator.next()).getBusNo());
                        result.setStopIndex1(sIndex);
                        result.setStopIndex2(dIndex);
                        result.setInterMedStopId(-1);
                        result.setBusId2(-1);
                        result.setInterMedStopIndex(-1);
                        result.setInterMedStopIndex2(-1);
                        searchResults.add(result);
                    }

                }

            }while(it.hasNext());
        }

        List<SearchResult> levelTwoList = getLevel2Results(sourceIds, destinationIds,sourceId,destinationId);
        searchResults.addAll(levelTwoList);
        return searchResults;


    }

    private List<SearchResult> getLevel2Results(List<Integer> sourceIds, List<Integer> destinationIds, int sourceId, int destinationId) {
        List<SearchResult> finalList = new ArrayList<SearchResult>();
        Iterator sIterator = sourceIds.iterator();
        boolean flag=false;
        while (sIterator.hasNext()){
            Iterator dIterator = destinationIds.iterator();
            int sRId =(Integer) sIterator.next();
            List<Integer> stops = routeService.getStopsAfter(sourceId,sRId );
            Iterator stopsIterator = stops.iterator();

            while (dIterator.hasNext()){
                int dRId = (Integer) dIterator.next();
                while (stopsIterator.hasNext())
                {
                    int id=(Integer)stopsIterator.next();
                    int temp = routeService.getStopIndex(id, dRId);
                    int dIndex = routeService.getStopIndex(destinationId, dRId );

                    if(temp != -1 && temp<dIndex){
                        List<Bus> destinationBuses = busService.getBusesByRoute(dRId);
                        Iterator dBIterator = destinationBuses.iterator();

                        while (dBIterator.hasNext()){

                            List<Bus> sourceBuses = busService.getBusesByRoute(sRId);
                            Iterator sBIterator = sourceBuses.iterator();
                            int tempBusId2 = ((Bus) dBIterator.next()).getBusNo();
                            while (sBIterator.hasNext()){
                                SearchResult searchResult = new SearchResult();
                                searchResult.setBusId1(((Bus) sBIterator.next()).getBusNo());
                                searchResult.setBusId2(tempBusId2);

                                if(searchResult.getBusId1() == searchResult.getBusId2()) continue;

                                searchResult.setStopIndex1(routeService.getStopIndex(sourceId, sRId));
                                searchResult.setStopIndex2(routeService.getStopIndex(destinationId, dRId));
                                searchResult.setInterMedStopIndex(routeService.getStopIndex(id, sRId));
                                searchResult.setInterMedStopIndex2(temp);
                                searchResult.setInterMedStopId(id);
                                searchResult.setInterMedStopName(busStopService.getStopWith(id));
                                finalList.add(searchResult);
                                 flag=true;



                            }


                        }
                        if(flag){
//                            flag=false;
                            break;
                        }
                        if (flag) {
                            flag = false;
                            break;

                        }

                    }

                }

            }
        }




      return finalList;  //Not Complete
    }

    private List<Integer> findCommonRoutes(List<Integer> sourceIds, List<Integer> destinationIds) {

        Iterator sIterator = sourceIds.iterator();
        Iterator dIterator = destinationIds.iterator();
        List<Integer> commonIds = new ArrayList<Integer>();
        int s = -1;
        int d = -1;

        if (sIterator.hasNext() && dIterator.hasNext()){
             s =  (Integer) sIterator.next();
             d =  (Integer) dIterator.next();

        }
        if(s==-1 || d ==-1) {
            return commonIds;
        }
        while (sIterator.hasNext() && dIterator.hasNext()){

            if (s == d){
                commonIds.add(s);
                s =  (Integer) sIterator.next();
                d =  (Integer) dIterator.next();

            }
            else if(s<d){
                 s = (Integer) sIterator.next();
            }
            else{
                 d = (Integer) dIterator.next();
            }

        }
        if (s == d){
            commonIds.add(s);
        }

        return commonIds;
    }


}
