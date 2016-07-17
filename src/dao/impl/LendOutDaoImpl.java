package dao.impl;

import entity.LendOut;
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
public class LendOutDaoImpl {

    public static List<LendOut> getAll(int page){
        List<LendOut> loList=new ArrayList<>();
        try{
            Properties config=new Properties();
            FileInputStream is = new FileInputStream(new File("src/fams.cfg.properties"));
            config.load(is);
            int pageSize= Integer.parseInt(config.getProperty("PAGESIZE"));
            is.close();

            String sql="select assets_out.*,users.user_name,fixed_assets.assets_name "+
                    "from fixed_assets RIGHT JOIN assets_out on fixed_assets.assets_id=assets_out.assets_id "+
                    "LEFT JOIN users on assets_out.assets_out_user=users.user_id "+
                    "limit "+(page-1)*pageSize+","+page*pageSize;
            Connection conn= ConnectionFactory.getConnection();
            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next()){
                LendOut lendOut=new LendOut();
                lendOut.setId(rs.getInt("assets_out_id"));
                lendOut.setAssets_id(rs.getInt("assets_id"));
                lendOut.setAssets_name(rs.getString("assets_name"));
                lendOut.setAdmin_id(rs.getInt("assets_out_admin"));
                lendOut.setUser_id(rs.getInt("assets_out_user"));
                lendOut.setUser_name(rs.getString("user_name"));
                lendOut.setDate(String.valueOf(rs.getDate("assets_out_date")));
                lendOut.setPurpose(rs.getString("assets_out_purpose"));
                lendOut.setRemark(rs.getString("assets_out_remark"));
                lendOut.setState(rs.getInt("assets_out_state"));
                loList.add(lendOut);
            }
            return loList;

        }catch (Exception e) {
            System.out.println("获取借出记录时出错");
            return null;
        }
    }

    public static List<LendOut> getNotReturn(int page){
        List<LendOut> loList=new ArrayList<>();
        try{
            Properties config=new Properties();
            FileInputStream is = new FileInputStream(new File("src/fams.cfg.properties"));
            config.load(is);
            int pageSize= Integer.parseInt(config.getProperty("PAGESIZE"));
            is.close();

            String sql="select assets_out.*,users.user_name,fixed_assets.assets_name "+
                    "from fixed_assets RIGHT JOIN assets_out on fixed_assets.assets_id=assets_out.assets_id "+
                    "INNER JOIN users on assets_out.assets_out_user=users.user_id "+
                    "and assets_out_state=0 "+
                    "limit "+(page-1)*pageSize+","+page*pageSize;
            Connection conn= ConnectionFactory.getConnection();
            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next()){
                LendOut lendOut=new LendOut();
                lendOut.setId(rs.getInt("assets_out_id"));
                lendOut.setAssets_id(rs.getInt("assets_id"));
                lendOut.setAdmin_id(rs.getInt("assets_out_admin"));
                lendOut.setUser_id(rs.getInt("assets_out_user"));
                lendOut.setAssets_name(rs.getString("assets_name"));
                lendOut.setUser_name(rs.getString("user_name"));
                lendOut.setDate(String.valueOf(rs.getDate("assets_out_date")));
                lendOut.setPurpose(rs.getString("assets_out_purpose"));
                lendOut.setRemark(rs.getString("assets_out_remark"));
                lendOut.setState(rs.getInt("assets_out_state"));
                loList.add(lendOut);
            }
            return loList;

        }catch (Exception e) {
            System.out.println("获取借出记录时出错 "+e);
            return null;
        }
    }
}
