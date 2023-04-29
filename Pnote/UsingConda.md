

修改conda创建虚拟环境和安装python第三方包的默认路径
https://blog.csdn.net/weixin_45405814/article/details/125553233

虚拟环境创建：
```
conda create -n XXX python = 3.9//版本可指定，不指定则为最新

activate XXX//进入虚拟环境
```


修改conda下载源为清华源
```
# 添加清华镜像
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/free/
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/main/
# 添加pytorch镜像
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/cloud/pytorch/
# for legacy win-64
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/cloud/peterjc123/
conda config --set show_channel_urls yes

```
GPU pytorch安装：
```
conda install pytorch torchvision torchaudio cudatoolkit=11.1
```

https://blog.csdn.net/HuangJM3/article/details/123685177

