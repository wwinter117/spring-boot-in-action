<#compress >
<#include "module/_macro.ftl">
<@head title="Halo后台管理-系统设置"></@head>
<div class="wrapper">
    <!-- 顶部栏模块 -->
    <#include "module/_header.ftl">
    <!-- 菜单栏模块 -->
    <#include "module/_sidebar.ftl">
    <div class="content-wrapper">
        <link rel="stylesheet" href="/static/plugins/toast/css/jquery.toast.min.css">
        <style type="text/css" rel="stylesheet">
            .form-horizontal .control-label{
                text-align: left;
            }
            .nav-tabs-custom > .nav-tabs > li.active {
                border-top-color: #d2d6de;
            }
        </style>
        <section class="content-header">
            <h1>
                设置
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li>
                    <a href="/admin">
                        <i class="fa fa-dashboard"></i> 首页</a>
                </li>
                <li class="active">设置</li>
            </ol>
        </section>
        <!-- tab选项卡 -->
        <section class="content container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#general" data-toggle="tab">常规设置</a>
                            </li>
                            <li>
                                <a href="#seo" data-toggle="tab">SEO设置</a>
                            </li>
                            <li>
                                <a href="#post" data-toggle="tab">文章设置</a>
                            </li>
                            <li>
                                <a href="#comment" data-toggle="tab">评论设置</a>
                            </li>
                            <li>
                                <a href="#admin" data-toggle="tab">后台设置</a>
                            </li>
                            <li>
                                <a href="#other" data-toggle="tab">其他设置</a>
                            </li>
                        </ul>
                        <!-- 基础设置 -->
                        <div class="tab-content">
                            <div class="tab-pane active" id="general">
                                <form method="post" class="form-horizontal" id="commonOptions">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="siteTitle" class="col-sm-2 control-label">网站标题：</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="siteTitle" name="site_title" value="${options.site_title?if_exists}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="siteUrl" class="col-sm-2 control-label">网站链接：</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="siteUrl" name="site_url" value="${options.site_url?default('localhost:8080')}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="siteLogo" class="col-sm-2 control-label">LOGO：
                                                <span data-toggle="tooltip" data-placement="top" title="如果不设置图片Logo，将使用网站标题作为Logo" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <div class="input-group">
                                                    <input type="text" class="form-control selectData" id="siteLogo" name="site_logo" value="${options.site_logo?if_exists}">
                                                    <span class="input-group-btn">
                                                        <button class="btn btn-default" type="button" onclick="openAttach()" style="border-radius: 0">选择</button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="siteFooter" class="col-sm-2 control-label">页脚信息：
                                                <span data-toggle="tooltip" data-placement="top" title="支持HTML" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <textarea class="form-control" rows="5" id="siteFooter" name="site_footer" style="resize: none">${options.site_footer?if_exists}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" class="btn btn-primary btn-sm" onclick="saveOptions('commonOptions')">保存</button>
                                    </div>
                                </form>
                            </div>
                            <!-- seo设置 -->
                            <div class="tab-pane" id="seo">
                                <form method="post" class="form-horizontal" id="seoOptions">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="keywords" class="col-sm-2 control-label">关键词：
                                                <span data-toggle="tooltip" data-placement="top" title="多个关键词使用,隔开" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="keywords" name="seo_keywords" value="${options.seo_keywords?if_exists}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="desc" class="col-sm-2 control-label">站点描述：</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="desc" name="seo_desc" value="${options.seo_desc?if_exists}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="baiduToken" class="col-sm-2 control-label">百度推送token：
                                                <span data-toggle="tooltip" data-placement="top" title="自行百度获取" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="baiduToken" name="seo_baidu_token" value="${options.seo_baidu_token?if_exists}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" class="btn btn-primary btn-sm" onclick="saveOptions('seoOptions')">保存</button>
                                    </div>
                                </form>
                            </div>
                            <!-- 文章设置 -->
                            <div class="tab-pane" id="post">
                                <form method="post" class="form-horizontal" id="postOptions">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="indexPosts" class="col-sm-2 control-label">首页显示条数：
                                                <span data-toggle="tooltip" data-placement="top" title="默认为10条" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="indexPosts" name="index_posts" value="${options.index_posts?default('10')}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="rssPosts" class="col-sm-2 control-label">RSS显示条数：</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="rssPosts" name="rss_posts" value="${options.rss_posts?if_exists}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="postSummary" class="col-sm-2 control-label">文章摘要字数：</label>
                                            <div class="col-sm-4">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" id="postSummary" name="post_summary" value="${options.post_summary?default('50')}">
                                                    <span class="input-group-btn">
                                                        <button class="btn btn-default" id="btn_update_summary" onclick="updateAllSummary()" type="button" style="border-radius: 0">更新</button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="sharePost" class="col-sm-2 control-label">文章分享：</label>
                                            <div class="col-sm-4">
                                                <label class="radio-inline">
                                                    <input type="radio" name="share_post" id="sharePost" value="true" ${((options.share_post?default('true'))=='true')?string('checked','')}> 开启
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="share_post" id="sharePost" value="false" ${((options.share_post?default('true'))=='false')?string('checked','')}> 关闭
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" class="btn btn-primary btn-sm" onclick="saveOptions('postOptions')">保存</button>
                                    </div>
                                </form>
                            </div>

                            <!-- 评论设置 -->
                            <div class="tab-pane" id="comment">
                                <form method="post" class="form-horizontal" id="commentOptions">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="CommentSystem" class="col-sm-2 control-label">评论系统：
                                                <span data-toggle="tooltip" data-placement="top" title="其他第三方评论系统在后台无法管理" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <label class="radio-inline">
                                                    <input type="radio" name="comment_system" id="CommentSystem" value="native" ${((options.comment_system?default('native'))=='native')?string('checked','')}> 原生
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="comment_system" id="CommentSystem" value="valine" ${((options.comment_system?default('native'))=='valine')?string('checked','')}> Valine
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="comment_system" id="CommentSystem" value="disqus" ${((options.comment_system?default('native'))=='disqus')?string('checked','')}> Disqus
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="comment_system" id="CommentSystem" value="livere" ${((options.comment_system?default('native'))=='livere')?string('checked','')}> Livere
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="comment_system" id="CommentSystem" value="changyan" ${((options.comment_system?default('native'))=='changyan')?string('checked','')}> 畅言
                                                </label>
                                            </div>
                                        </div>

                                        <!-- 原生设置 -->
                                        <div class="native-options" style="display: none">
                                            <div class="form-group">
                                                <label for="CommentSystem" class="col-sm-2 control-label">是否启用：
                                                    <span data-toggle="tooltip" data-placement="top" title="其他第三方评论系统在后台无法管理" style="cursor: pointer">
                                                        <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                    </span>
                                                </label>
                                                <div class="col-sm-4">
                                                    <label class="radio-inline">
                                                        <input type="radio" name="comment_system" id="CommentSystem" value="native" disabled> 启用
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input type="radio" name="comment_system" id="CommentSystem" value="valine"> 禁用
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- valine选项 -->
                                        <div class="valine-options" style="display: none">
                                            <div class="form-group">
                                                <label for="valineAppId" class="col-sm-2 control-label">APP ID：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="valineAppId" name="valine_appid" value="${options.valine_appid?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="valineAppKey" class="col-sm-2 control-label">APP KEY：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="valineAppKey" name="valine_appkey" value="${options.valine_appkey?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="valineAvatar" class="col-sm-2 control-label">头像类型：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="valineAvatar" name="valine_avatar" value="${options.valine_avatar?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="valinePlaceholder" class="col-sm-2 control-label">占位提示：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="valinePlaceholder" name="valine_placeholder" value="${options.valine_placeholder?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="valineCss" class="col-sm-2 control-label">自定义CSS：
                                                    <span data-toggle="tooltip" data-placement="top" title="对评论框自定义样式，如边距等" style="cursor: pointer">
                                                        <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                    </span>
                                                </label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control" rows="5" id="valineCss" name="valine_css" style="resize: none">${options.valine_css?if_exists}</textarea>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- disqus选项 -->
                                        <div class="disqus-options" style="display: none">
                                            <div class="form-group">
                                                <label for="disqusShortname" class="col-sm-2 control-label">Disqus ShortName：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="disqusShortname" name="disqus_shortname" value="${options.disqus_shortname?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="disqusCss" class="col-sm-2 control-label">自定义CSS：
                                                    <span data-toggle="tooltip" data-placement="top" title="对评论框自定义样式，如边距等" style="cursor: pointer">
                                                        <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                    </span>
                                                </label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control" rows="5" id="disqusCss" name="disqus_css" style="resize: none">${options.disqus_css?if_exists}</textarea>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- livere选项 -->
                                        <div class="livere-options" style="display: none">
                                            <div class="form-group">
                                                <label for="livereDataUid" class="col-sm-2 control-label">livere data-uid：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="livereDataUid" name="livere_data_uid" value="${options.livere_data_uid?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="livereCss" class="col-sm-2 control-label">自定义CSS：
                                                    <span data-toggle="tooltip" data-placement="top" title="对评论框自定义样式，如边距等" style="cursor: pointer">
                                                        <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                    </span>
                                                </label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control" rows="5" id="livereCss" name="livere_css" style="resize: none">${options.livere_css?if_exists}</textarea>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- 畅言选项 -->
                                        <div class="changyan-options" style="display: none">
                                            <div class="form-group">
                                                <label for="changyanAppId" class="col-sm-2 control-label">APP ID：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="changyanAppId" name="changyan_appid" value="${options.changyan_appid?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="changyanConf" class="col-sm-2 control-label">CONF：</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="changyanConf" name="changyan_conf" value="${options.changyan_conf?if_exists}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="changyanCss" class="col-sm-2 control-label">自定义CSS：
                                                    <span data-toggle="tooltip" data-placement="top" title="对评论框自定义样式，如边距等" style="cursor: pointer">
                                                        <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                    </span>
                                                </label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control" rows="5" id="changyanCss" name="changyan_css" style="resize: none">${options.changyan_css?if_exists}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" class="btn btn-primary btn-sm" onclick="saveOptions('commentOptions')">保存</button>
                                    </div>
                                </form>
                            </div>

                            <!-- 后台设置 -->
                            <div class="tab-pane" id="admin">
                                <form method="post" class="form-horizontal" id="adminOptions">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="adminPjax" class="col-sm-2 control-label">启用pjax：</label>
                                            <div class="col-sm-4">
                                                <label class="radio-inline">
                                                    <input type="radio" name="admin_pjax" id="adminPjax" value="true" ${((options.admin_pjax?default('true'))=='true')?string('checked','')}> 启用
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="admin_pjax" id="adminPjax" value="false" ${((options.admin_pjax?if_exists)=='false')?string('checked','')}> 禁用
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="adminLayout" class="col-sm-2 control-label">后台布局：</label>
                                            <div class="col-sm-4">
                                                <label class="radio-inline">
                                                    <input type="radio" name="admin_layout" id="adminLayout" value="" ${((options.admin_layout?default(''))=='')?string('checked','')}> 正常布局
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="admin_layout" id="adminLayout" value="layout-boxed" ${((options.admin_layout?default(''))=='layout-boxed')?string('checked','')}> 盒子布局
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="adminTheme" class="col-sm-2 control-label">后台主题：</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="adminTheme" name="admin_theme">
                                                    <option value="skin-blue" ${((options.admin_theme?default('skin-blue'))=='skin-blue')?string('selected','')}>默认主题</option>
                                                    <option value="skin-blue-light" ${((options.admin_theme?default('skin-blue'))=='skin-blue-light')?string('selected','')}>上蓝左白</option>
                                                    <option value="skin-black" ${((options.admin_theme?default('skin-blue'))=='skin-black')?string('selected','')}>上白左黑</option>
                                                    <option value="skin-black-light" ${((options.admin_theme?default('skin-blue'))=='skin-black-light')?string('selected','')}>上白左白</option>
                                                    <option value="skin-green" ${((options.admin_theme?default('skin-blue'))=='skin-green')?string('selected','')}>上绿左黑</option>
                                                    <option value="skin-green-light" ${((options.admin_theme?default('skin-blue'))=='skin-green-light')?string('selected','')}>上绿左白</option>
                                                    <option value="skin-purple" ${((options.admin_theme?default('skin-blue'))=='skin-purple')?string('selected','')}>上紫左黑</option>
                                                    <option value="skin-purple-light" ${((options.admin_theme?default('skin-blue'))=='skin-purple-light')?string('selected','')}>上紫左白</option>
                                                    <option value="skin-red" ${((options.admin_theme?default('skin-blue'))=='skin-red')?string('selected','')}>上红左黑</option>
                                                    <option value="skin-red-light" ${((options.admin_theme?default('skin-blue'))=='skin-red-light')?string('selected','')}>上红左白</option>
                                                    <option value="skin-yellow" ${((options.admin_theme?default('skin-blue'))=='skin-yellow')?string('selected','')}>上黄左黑</option>
                                                    <option value="skin-yellow-light" ${((options.admin_theme?default('skin-blue'))=='skin-yellow-light')?string('selected','')}>上黄左白</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="sidebarStyle" class="col-sm-2 control-label">侧边栏样式：</label>
                                            <div class="col-sm-4">
                                                <label class="radio-inline">
                                                    <input type="radio" name="sidebar_style" id="sidebarStyle" value="" ${((options.sidebar_style?default(''))=='')?string('checked','')}> 展开
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="sidebar_style" id="sidebarStyle" value="sidebar-collapse" ${((options.sidebar_style?default(''))=='sidebar-collapse')?string('checked','')}> 收拢
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="postEditor" class="col-sm-2 control-label">文章编辑器：
                                                <span data-toggle="tooltip" data-placement="top" title="请勿将它们混用" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="postEditor" name="post_editor">
                                                    <option value="editor.md" ${((options.post_editor?default('editor.md'))=='editor.md')?string('selected','')}>Markdown</option>
                                                    <option value="ckeditor" ${((options.post_editor?default('editor.md'))=='ckeditor')?string('selected','')}>富文本</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="pageEditor" class="col-sm-2 control-label">页面编辑器：
                                                <span data-toggle="tooltip" data-placement="top" title="请勿将它们混用" style="cursor: pointer">
                                                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="pageEditor" name="page_editor">
                                                    <option value="editor.md" ${((options.page_editor?default('editor.md'))=='editor.md')?string('selected','')}>Markdown</option>
                                                    <option value="ckeditor" ${((options.page_editor?default('editor.md'))=='ckeditor')?string('selected','')}>富文本</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" class="btn btn-primary btn-sm" onclick="saveOptions('adminOptions')">保存</button>
                                    </div>
                                </form>
                            </div>

                            <!-- 其他设置 -->
                            <div class="tab-pane" id="other">
                                <form method="post" class="form-horizontal" id="otherOptions">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="statisticsCode" class="col-sm-2 control-label">统计代码：
                                                <span data-toggle="tooltip" data-placement="top" title="可以使用cnzz，百度，google等" style="cursor: pointer">
                                                        <i class="fa fa-question-circle" aria-hidden="true"></i>
                                                    </span>
                                            </label>
                                            <div class="col-sm-4">
                                                <textarea class="form-control" rows="6" id="statisticsCode" name="statistics_code" style="resize: none">${options.statistics_code?if_exists}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" class="btn btn-primary btn-sm" onclick="saveOptions('otherOptions')">保存</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="/static/plugins/toast/js/jquery.toast.min.js"></script>
        <script src="/static/plugins/layer/layer.js"></script>
        <@compress single_line=true>
        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip();
                checkCommentOption();
            });
            function openAttach() {
                layer.open({
                    type: 2,
                    title: '所有附件',
                    shadeClose: true,
                    shade: 0.5,
                    area: ['90%', '90%'],
                    content: '/admin/attachments/select',
                    scrollbar: false
                });
            }
            function saveOptions(option) {
                var param = $('#'+option).serialize();
                $.ajax({
                    type: 'post',
                    url: '/admin/option/save',
                    data: param,
                    success: function (result) {
                        showMsg("保存成功！","success",1000);
                    }
                });
            }
            function updateAllSummary() {
                $.ajax({
                    type: 'GET',
                    url: '/admin/posts/updateSummary',
                    data: {
                        postSummary : $('#postSummary').val()
                    },
                    success: function (data) {
                        if(data=="success"){
                            showMsg("所有文章摘要更新成功！","success",1000);
                        }else{
                            showMsg("更新失败！","success",2000);
                        }
                    }
                });
            }
            function checkCommentOption() {
                var native = $('input:radio[value=native]:checked').val();
                var valine = $('input:radio[value=valine]:checked').val();
                var disqus = $('input:radio[value=disqus]:checked').val();
                var livere = $('input:radio[value=livere]:checked').val();
                var changyan = $('input:radio[value=changyan]:checked').val();
                if(native!=null){
                    $('.native-options').show();
                }else{
                    $('.native-options').hide();
                }
                if(valine!=null){
                    $('.valine-options').show();
                }else{
                    $('.valine-options').hide();
                }
                if(disqus!=null){
                    $('.disqus-options').show();
                }else{
                    $('.disqus-options').hide();
                }
                if(livere!=null){
                    $('.livere-options').show();
                }else{
                    $('.livere-options').hide();
                }
                if(changyan!=null){
                    $('.changyan-options').show();
                }else{
                    $('.changyan-options').hide();
                }
            }
            function viewLayout() {
                var layout = $('input:radio[value=layout-boxed]:checked').val();
                if(layout!=null){
                    $('body').addClass('layout-boxed');
                }else{
                    $('body').removeClass('layout-boxed');
                }
            }
            function viewSideBar() {
                var layout = $('input:radio[value=sidebar-collapse]:checked').val();
                if(layout!=null){
                    $('body').addClass('sidebar-collapse');
                }else{
                    $('body').removeClass('sidebar-collapse');
                }
            }
            $('input[name=comment_system]').click(function () {
                checkCommentOption();
            });
            $('input[name=admin_layout]').click(function () {
                viewLayout();
            });
            $('input[name=sidebar_style]').click(function () {
                viewSideBar();
            });
            $(function () {
                var beforeTheme;
                $('#adminTheme').change(function () {
                    if($('body').hasClass("${options.admin_theme?default('skin-blue')}")){
                        $('body').removeClass("${options.admin_theme?default('skin-blue')}");
                    }
                    if(beforeTheme!=null){
                        $('body').removeClass(beforeTheme);
                    }
                    $('body').addClass($(this).val());
                    beforeTheme = $(this).val();
                })
            })
        </script>
        </@compress>
    </div>
    <#include "module/_footer.ftl">
    <div class="control-sidebar-bg"></div>
</div>
<@footer></@footer>
</#compress>