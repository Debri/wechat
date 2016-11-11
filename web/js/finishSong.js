$(document).ready(function(){
	$.ajax({
		type:"GET",
        //获取已播歌曲
		url:"/song?action=findPlayedSong",
		data:'',
		/*success:function(data){
			var songData = data.data;
			var SongHtml='';
			for(var i=0;i<songData.length;i++){
				SongHtml+="<div class='user'>"+
			"<div class='con_header'>"+
				"<p>点歌人："+songData[i].name+"</p>"+
			"</div>"+
			"<div class='con_content'>"+
					"<div class='left'>"+
						"<div class='song'><p>"+songData[i].songname+"<p></div>"+
						"<div class='singer'><p>"+songData[i].pername+"</p></div>"
					"</div>"+
					"<div class='right'>"+
						"<p>To "+songData[i].for+"：</p>"+
						"<p class='words'>"+songData[i].message+"</p>"+
						"<p class='date'>"+songData[i].time+"</div>"+
            "</div>"+"</p>"+
					"</div>"+
				"</ul>"+
			"</div>"+
		"+</div>";}
		   $("#content").after(SongHtml);
		}*/
	});
});