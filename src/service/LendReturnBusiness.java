package service;

import dao.impl.LendOutDaoImpl;
import dao.impl.ReturnBackDaoImpl;
import entity.LendOut;
import entity.ReturnBack;

import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public class LendReturnBusiness {
    public static List<LendOut> getAllLend(int page){
        return LendOutDaoImpl.getAll(page);
    }

    public static List<LendOut> getLendNotReturn(int page){
        return LendOutDaoImpl.getNotReturn(page);
    }

    public static List<ReturnBack> getAllReturn(int page){
        return ReturnBackDaoImpl.getAll(page);
    }
}
