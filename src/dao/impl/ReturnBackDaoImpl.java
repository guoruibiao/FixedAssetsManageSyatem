package dao.impl;

import entity.ReturnBack;
import util.ConnectionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2016/7/16.
 */
public class ReturnBackDaoImpl {

    public static List<ReturnBack> getAll(int page){
        List<ReturnBack> rbList=new ArrayList<>();
        try{
            Properties config=new Properties();
            FileInputStream is = new FileInputStream(new File("src/fams.cfg.properties"));
            config.load(is);
            int pageSize= Integer.parseInt(config.getProperty("PAGESIZE"));
            is.close();

            String sql="select assets_in.*,users.user_name,fixed_assets.assets_name "+
                    "from fixed_assets RIGHT JOIN assets_in on fixed_assets.assets_id=assets_in.assets_id "+
                    "LEFT JOIN users on assets_in.assets_in_user=users.user_id "+
                    "limit "+(page-1)*pageSize+","+page*pageSize;
            Connection conn= ConnectionFactory.getConnection();
            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next()){
                ReturnBack returnBack=new ReturnBack();
                returnBack.setId(rs.getInt("assets_in_id"));
                returnBack.setAdmin_id(rs.getInt("assets_in_admin"));
                returnBack.setAssets_id(rs.getInt("assets_id"));
                returnBack.setAssets_name(rs.getString("assets_name"));
                returnBack.setUser_id(rs.getInt("assets_in_user"));
                returnBack.setUser_name(rs.getString("user_name"));
                returnBack.setDate(rs.getDate("assets_in_date"));
                returnBack.setRemark(rs.getString("assets_in_remark"));
                rbList.add(returnBack);
            }
            return rbList;

        }catch (Exception e) {
            System.out.println("获取借出记录时出错");
            return null;
        }
    }
}
