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

            List<Integer> haults = routeDao.getAllStopsForRoute(routeId.intValue());

            Iterator haultIterator = haults.iterator();

            while (haultIterator.hasNext()){

                Integer stopId = (Integer) haultIterator.next();
                String stopName = busStopDao.getStopWith(stopId);
                if (haultIterator.hasNext())
                    routeStr.concat(stopName + "-");
                else routeStr.concat(stopName);

                System.out.println("stop = " + routeStr + "");

            }
            System.out.println(routeStr);
            Path path = new Path();
            path.setPathName(routeStr);
            path.setRouteId(routeId);
            System.out.println("\n\npathname="+path.getPathName() + "id==="+ path.getRouteId() + "Path ="+path);
            paths.add(path);

        }

        return paths;

    }

    public List getRouteIds(){
        List routeIds = routeDao.getRouteIds();
        return routeIds;
    }
}
