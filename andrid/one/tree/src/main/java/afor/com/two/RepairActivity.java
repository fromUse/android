package afor.com.two;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import afor.com.two.adpater.SimpleTreeListViewAdapter;
import afor.com.two.bean.FileBean;

public class RepairActivity extends AppCompatActivity {

    private ListView mTree;
    private SimpleTreeListViewAdapter<FileBean> mAdapter;
    private List<FileBean> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com);



                mTree = (ListView) findViewById(R.id.id_listview);
        initDatas();
        try {
            mAdapter = new SimpleTreeListViewAdapter<FileBean>(mTree,this,mDatas,1);
            mTree.setAdapter(mAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void initDatas() {
        mDatas = new ArrayList<FileBean>();
        FileBean bean = new FileBean(1,0,"电脑维护问题");
        mDatas.add(bean);
        bean = new FileBean(2,0,"网络维护问题");
        mDatas.add(bean);
        bean = new FileBean(3,1,"1.如何进入笔记本电脑BIOS");
        mDatas.add(bean);
        bean = new FileBean(4,3,"故障现象：一台二手的COMPAQ笔记本电脑，需进入BIOS进行一些设置，可是不知道快捷键。故障分析与处理：大多数笔记本电脑进入BIOS的方式都不同于台式机，笔记本电脑大多是按[F1]、[F2]、[F10]或[CTRL+ALT+ESC]键等。");
        mDatas.add(bean);
        bean = new FileBean(5,1,"2.自动关机后无法再开机");
        mDatas.add(bean);
        bean = new FileBean(6,5,"故障现象：一台电脑在使用中突然关机，按主机电源后无法开机，屏幕总是显示黑色，但电源对主板供电正常。故障分析与处理：估计是内存松脱，打开机箱后，将内存重新拔插，开机后故障依旧，但主机并没有发出任何声音，可排除内存出现故障。再重新拔插显示器和更换一块有问题的CPU后，故障照旧，于是怀疑BIOS出现了问题，将CMOS中的电放掉后，再重新开机，一切正常。");
        mDatas.add(bean);
        bean = new FileBean(7,2,"1.网络安全基础措施");
        mDatas.add(bean);
        bean = new FileBean(8,7,"安装杀毒软件,定期杀毒并更新系统补丁,不安装来历不明的软件。");
        mDatas.add(bean);
        bean = new FileBean(9,2,"2.wifi共享冲突");
        mDatas.add(bean);
        bean = new FileBean(10,9,"查看是否有安装了共享软件，如猎豹WiFi等。如果有，请卸载！");
        mDatas.add(bean);
        bean = new FileBean(11,1,"3.蓝屏问题");
        mDatas.add(bean);
        bean = new FileBean(12,11,"电脑中病毒");
        mDatas.add(bean);
        bean = new FileBean(13,12,"解决方法:进入安全模式，进行杀毒。");
        mDatas.add(bean);
        bean = new FileBean(14,11,"硬软件不兼容");
        mDatas.add(bean);
        bean = new FileBean(15,14,"解决方法:把近期安装的驱动或者软件进行删除。");
        mDatas.add(bean);
        bean = new FileBean(16,11,"蓝屏代码");
        mDatas.add(bean);
        bean = new FileBean(17,16,"0X0000 操作完成  0X0001 不正确的函数   0X0002 系统找不到指定的文件   0X0003 系统找不到指定的路径   0X0004 系统无法打开文件   0X0005 拒绝存取   0X0006 无效的代码 0X0007 内存控制模块已损坏 0X0008 内存空间不足，无法处理这个指令  0X0009 内存控制模块位址无效 0X000A 环境不正确 0X000B 尝试载入一个格式错误的程序 0X000C 存取码错误 0X000D 资料错误 0X000E 内存空间不够，无法完成这项操作 0X000F 系统找不到指定的硬盘 0X0010 无法移除目录 0X0011 系统无法将文件移到其他的硬盘 0X0012 没有任何文件 0X0019 找不到指定扇区或磁道 0X001A 指定的磁盘或磁片无法存取 0X001B 磁盘找不到要求的装置 0X001C 打印机没有纸 0X001D 系统无法将资料写入指定的磁盘 0X001E 系统无法读取指定的装置 0X001F 连接到系统的某个装置没有作用 0X0021 文件的一部分被锁定，现在无法存取 0X0024 开启的分享文件数量太多 0X0026 到达文件结尾 0X0027 磁盘已满 0X0036 网络繁忙");
        mDatas.add(bean);

    }
}
