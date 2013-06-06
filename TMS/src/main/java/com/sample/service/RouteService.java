package com.sample.service;

import com.sample.dao.BusStopDao;
import com.sample.dao.RouteDao;
import com.sample.model.BusRoute;
import com.sample.model.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class RouteService {

   private RouteDao routeDao;
    private BusStopDao busStopDao;

    public RouteService() {
    }

    @Autowired

    public RouteService(RouteDao routeDao, BusStopDao busStopDao) {
        this.routeDao = routeDao;
        this.busStopDao = busStopDao;
    }

    public List<Path> getAllRoutes(){
        int i=0;
        String[] route = new String[10];
        String routeStr = new String("");

        List<Path> paths = new ArrayList<Path>();
        List<Integer> routeIds = getRouteIds();
        Iterator routeIterator = routeIds.iterator();

        while (routeIterator.hasNext()){

            Integer routeId =   (Integer) routeIterator.next();
            Path path = getRouteFor(routeId);
            paths.add(path);

        }

        return paths;

    }

    public List getRouteIds(){
        List routeIds = routeDao.getRouteIds();
        return routeIds;
    }


    public Path getRouteFor(int routeId) {

        Path path = new Path();
        String routeStr = new String("");

        List<Integer> haults = routeDao.getAllStopsForRoute(routeId);
        Iterator it = haults.iterator();


        while (it.hasNext()){

                Integer stopId = (Integer) it.next();
                String stopName = busStopDao.getStopWith(stopId.intValue());
            try{
            if (it.hasNext())
                {
                    routeStr=routeStr.concat(stopName);
                    routeStr=routeStr.concat("-");
                }
                else {routeStr=routeStr.concat(stopName);break;}

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        path.setPathName(routeStr);
        path.setRouteId(routeId);


        return path;
    }
    public int getStopCount(int route_no)
    {
        return routeDao.getStopCount(route_no);

    }

    public int getStopForRoute(int routeNo, int stop_index)
    {

        int stop_id=routeDao.getStopForRoute(routeNo, stop_index);
        return stop_id;

    }

    public int getNewRouteID()
    {
        return routeDao.getNewRouteID();
    }

    public void saveRoute(BusRoute busRoute) {
        routeDao.saveRoute(busRoute);
    }

    public void delete(BusRoute busRoute) {
        routeDao.delete(busRoute);
    }


    public List<Integer> getStopIndices(int routeId) {
        return routeDao.getStopIndicesForRoute(routeId);
    }

    public void deleteRouteStop(int route,int stopIndex)
    {
        routeDao.deleteRouteStop(route,stopIndex);
    }

    public int getRouteStopIndexCount(int route)
    {
        return routeDao.getRouteStopIndexCount(route);
    }

    public void insertStopInRoute(int route,int stopindex,int bus_stop,String stop_time)
    {

        routeDao.insertStopInRoute(route, stopindex, bus_stop,stop_time);

    }


    public int getStopIndex(int id, Integer rId) {
        return routeDao.getStopIndex(id, rId);
    }

    public List getStopsAfter(int sourceId, int rId) {
        int i = getStopIndex(sourceId, rId);

        return routeDao.getStopsAfter(i, rId);
    }
   public int getStopId(int id, Integer rId) {
        return routeDao.getStopId(id,rId);
    }

    }



