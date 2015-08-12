<jsp:include page="template/header.jsp"></jsp:include>
<link href="css/video-js.min.css" rel="stylesheet" type="text/css">
<script src="js/video.js"></script>
<script>
	videojs.options.flash.swf = "video/video-js.swf";
</script>
<body>
	<video id="example_video_1" class="video-js vjs-default-skin" controls
		preload="none" width="640" height="264"
		poster="http://video-js.zencoder.com/oceans-clip.png" data-setup="{}">
		<source src="video/v1.mp4" type='video/mp4' />
		<track kind="captions" src="demo.captions.vtt" srclang="en"
			label="English"></track>
		<!-- Tracks need an ending tag thanks to IE9 -->
		<track kind="subtitles" src="demo.captions.vtt" srclang="en"
			label="English"></track>
	</video>

</body>
