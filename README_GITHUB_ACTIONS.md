# webhome-spider 云打包

## 使用方法

1. **新建 GitHub 仓库**（或用现有仓库）
2. **上传文件**：
   - 把 `com/fongmi/spider/WebHomeSpider.java` 传到仓库根目录下的 `com/fongmi/spider/` 文件夹
   - 把 `.github/workflows/build.yml` 传到仓库的 `.github/workflows/` 文件夹
3. **触发构建**：
   - 进仓库 **Actions** 标签页
   - 选 **Build webhome-spider JAR** → **Run workflow** → **Run workflow**
4. **下载产物**：
   - 构建完成后（约 1-2 分钟），点开该 workflow run
   - 底部 **Artifacts** 下载 `webhome-spider.jar`
5. **部署到 OK影视**：
   - 把 `webhome-spider.jar` 放到 `ZX/zx.jar` 同目录
   - 在配置里追加：
     ```json
     "spider": "./ZX/zx.jar;md5;...; ./webhome-spider.jar"
     ```
   - `sites` 里新增站点用 `api: "csp_webhome"` + `homePage`

## 文件结构
```
你的仓库/
├── com/fongmi/spider/WebHomeSpider.java
└── .github/workflows/build.yml
```

## 多站点配置示例
```json
{
  "spider": "./ZX/zx.jar;md5;...; ./webhome-spider.jar",
  "sites": [
    {"key": "ytb-home", "name": "YouTube", "type": 3, "api": "csp_webhome", "homePage": "http://192.168.2.105:5050/html/ytb.html", "searchable": 1},
    {"key": "bili-home", "name": "哔哩哔哩", "type": 3, "api": "csp_webhome", "homePage": "http://192.168.2.105:5050/html/bili.html", "searchable": 1}
  ]
}
```