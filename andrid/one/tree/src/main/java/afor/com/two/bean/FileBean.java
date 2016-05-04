package afor.com.two.bean;

import afor.com.two.utlis.annotion.TreeNodeId;
import afor.com.two.utlis.annotion.TreeNodeLabel;
import afor.com.two.utlis.annotion.TreeNodePid;

/**
 * Created by jia on 2016/5/4.
 */
public class FileBean {


    @TreeNodeId
    private int id;

    @TreeNodePid
    private int pId;

    @TreeNodeLabel
    private String label;

    private String desc;

    public FileBean(int id, int pId, String label)
    {
        this.id = id;
        this.pId = pId;
        this.label = label;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getpId()
    {
        return pId;
    }

    public void setpId(int pId)
    {
        this.pId = pId;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
