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
    <link href="${ctx}/assets/plugins/highlight/styles/default.css" rel="stylesheet">

    <link href="${ctx}/assets/css/mahua.css?v=3" rel="stylesheet" type="text/css" />

<#-- jquery -->
    <script type="text/javascript" src="${ctx}/assets/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/assets/plugins/marked/lib/marked.js"></script>
<#-- bootstrap -->
    <script type="text/javascript" src="${ctx}/assets/plugins/bootstrap/dist/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="mahua-container">
		<div id="mahua-docname" class="mahua-docanme"></div>
		<ul class="mahua-topbar" id="mahua-topbar">
		</ul>

		<div class="mahua-spliter" id="mahua-spliter"></div>
		<div class="mahua-left">
			<textarea id="mahua-editor"
                      style="height:100%;width:50%;max-width::50%">
            </textarea>
		</div>
		<div class="mahua-right" id="mahua-result"> </div>
	</div>
</body>

	<script type="text/javascript" src="${ctx}/assets/js/all.js"></script>

</html>