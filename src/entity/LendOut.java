package entity;

/**
 * Created by Administrator on 2016/7/16.
 */
public class LendOut {
    private int id;
    private int assets_id;
    private String assets_name;
    private int admin_id;
    private int user_id;
    private String user_name;
    private String date;
    private String purpose;
    private String remark;
    private int state;

    @Override
    public String toString() {
        return id+"\t"+assets_id+"\t"+assets_name+"\t"+admin_id+"\t"+user_id+"\t"+user_name+"\t"+date+"\t"+purpose+"\t"+stateCase()+"\t"+remark;
    }

    private String stateCase() {
        if(state==0){
            return "未归还";
        }else if(state==1){
            return "已归还";
        }else{
            return "未知";
        }
    }

    public String getAssets_name() {
        return assets_name;
    }

    public void setAssets_name(String assets_name) {
        this.assets_name = assets_name;
    }
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssets_id() {
        return assets_id;
    }

    public void setAssets_id(int assets_id) {
        this.assets_id = assets_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
