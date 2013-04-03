package com.sample.service;

import com.sample.dao.BusStopDao;
import com.sample.model.BusStop;
import com.sample.dao.SearchDao;
import com.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SearchService {

    private SearchDao searchDao;
    public SearchService() {


    }

    @Autowired

    public SearchService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    public List<BusStop> getAllStops(String src,String destination) {
        return searchDao.getSearchList(src, destination);
    }


}
