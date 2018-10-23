<#assign ctx=ctx>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    
    <title>${title}</title>
    
    <#-- 引入bootstrap样式 -->
    <link href="${ctx}/assets/plugins/bootstrap/dist/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/bootstrap/dist/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet">
	<#-- Font Awesome-->
    <link href="${ctx}/assets/plugins/font-awesome/css/font-awesome.css" type="text/css" rel="stylesheet">
    <#-- 引入bootstrap-table样式 -->
    <link href="${ctx}/assets/plugins/bootstrap-table/dist/bootstrap-table.css" type="text/css" rel="stylesheet">

    <#-- 引入bootstrap-dialog样式 -->
    <link href="${ctx}/assets/plugins/bootstrap3-dialog/dist/css/bootstrap-dialog.min.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/highlight/styles/default.css" rel="stylesheet">

    <#-- jquery -->
    <script type="text/javascript" src="${ctx}/assets/js/jquery-1.9.1.min.js"></script>
    <#-- bootstrap -->
    <script type="text/javascript" src="${ctx}/assets/plugins/bootstrap/dist/js/bootstrap.min.js"></script>
</head>

	<body>
        <div>
            <span>获取服务端数据 ${ctx}</span>
            |
            <button id="btn_refresh" onclick="refresh()"
                    type="button" class="btn btn-default btn-space">
                <span class="fa fa-refresh" class="btn-icon-space"></span>
            </button>
            |
            <button id="btn_load" onclick="loaderData()"
                    type="button" class="btn btn-default btn-space">
                加载博文
            </button>
            |
            <button id="btn_submit" onclick="onSubmit()"
                    type="button" class="btn btn-default btn-space">
                提交
            </button>
            |
            <a id="wblog_md" href="${ctx}/md2html"
               target="_blank" >编排</a>
        </div>

        <#-- 加密密钥 -->
        <input id="secretKey" type="hidden" value="${secretKey}"/>

    	<span>MD 正文</span>
        <#-- markdown 格式的数据 -->
        <input id="mdDataVal" type="hidden" value="${data}"/>
        <#-- html 格式的数据 -->
        <input id="htmlDataVal" type="hidden" value=""/>
        <textarea id="editormd-context-markdown-doc" name="articleContext"></textarea>

        <div id="content"></div>
	</body>

    <script type="text/javascript" src="${ctx}/assets/plugins/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/plugins/bootstrap3-dialog/dist/js/bootstrap-dialog.min.js"></script>

	<script type="text/javascript" src="${ctx}/assets/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="${ctx}/assets/plugins/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>

    <#-- 加解密 -->
    <script type="text/javascript" src="${ctx}/assets/plugins/crypto-js/crypto-js.js"></script>
    <#--<script type="text/javascript" src="${ctx}/assets/plugins/crypto-js/src/aes.js"></script>-->
    <#--<script type="text/javascript" src="${ctx}/assets/plugins/crypto-js/src/core.js"></script>-->
    <#--<script type="text/javascript" src="${ctx}/assets/plugins/crypto-js/src/cipher-core.js"></script>-->
    <script type="text/javascript" src="${ctx}/assets/js/js-cryptoJS.js"></script>

    <script src="${ctx}/assets/plugins/marked/lib/marked.js"></script>
    <script src="${ctx}/assets/plugins/highlight/highlight.pack.js"></script>

    <script>
        // 实例化高亮
        hljs.initHighlightingOnLoad();

        //载入
        $(document).ready(function() {
            refresh();
        });
    </script>

    <script>
        /*
		* 刷新
		*/
        function refresh() {
            $('#content').html("");
            $('#mdDataVal').val("");
            $('#htmlDataVal').val("");

            //secret key
            var secretKeyVal = "abcdefgabcdefg12"; //$("#secretKey").val();
            var key  = CryptoJS.enc.Utf8.parse(secretKeyVal)
            alert("加密密钥：" + key);

            var data = $("#editormd-context-markdown-doc").val();
            var encodeStr = encrypt(data, key);
            alert("加密后："+encodeStr);

//            var bytes = decrypt(encodeStr, key);
//            alert("解密后："+ bytes);

            // 请求后端数据
            $.ajax({
                url:  "${ctx}/demo/data?cryptoType=AES&encodeStr=" + encodeURIComponent(encodeStr),
                type: 'POST',
                success: function(rs) {
                    if (rs["code"] == '00000000') {
                        $('#mdDataVal').val(rs["data"]);

                        var htmlVal= marked(rs["data"]);
                        $('#htmlDataVal').val(htmlVal);

                        $('#content').html(htmlVal);
                    }else {
                        alert(rs["message"]);
                    }
                }
            });
        }

        function loaderData() {
            var md = $('#mdDataVal').val();

            var htmlVal= marked(md);
            $('#htmlDataVal').val(htmlVal);
            $('#content').html(htmlVal);
        }

        /* 提交 */
        function onSubmit() {
            var htmlVal = $('#htmlDataVal').val();
            layer.msg(htmlVal, {time: 10000});

        }
    </script>

	<#-- web弹层组件 -->
	<script type="text/javascript" src="${ctx}/assets/plugins/layer/layer.js"></script>

</html>