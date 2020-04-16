# BilibiliVideoConvert
通过ffmpeg对B站下载的视频进行处理，转换成mp4格式

Bilibili下载的视频会被保存到`Android/data/tv.danmaku.bili/downlaod/一串数字`文件夹里  
在该文件夹里，会以以下结构保存下载的视频
├── 1
│   ├── 64
│   │   ├── audio.m4s
│   │   ├── index.json
│   │   └── video.m4s
│   ├── danmaku.xml
│   └── entry.json
├── 2
│   ├── 64
│   │   ├── audio.m4s
│   │   ├── index.json
│   │   └── video.m4s
│   ├── danmaku.xml
│   └── entry.json
.....................
其中`entry.json`文件里含有视频名称
`video.m4s`可以以mp4格式打开，但是没声音，声音在`audio.m4s`文件里

利用ffmpeg把音频文件合并到视频里
