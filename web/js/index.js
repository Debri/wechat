/*window.onload=function(){
    /*在现有元素前添加元素
    newElement  被插入的元素
    targetElement 新元素*/
	/*function insertAfter(newElement,targetElement){
		var parent=targetElement.parentNode;
		if(parent.lastchild==targetElement){
			parent.appendChild(newElement);
		}else{
			parent.insertBefore(newElement,targetElement.nextSibling);
		}
	}

	var Date={
		"SongName":["演员——薛之谦","红日——李克勤"]
	};

	var button=document.getElementById("button");
	/*添加一个歌单，包含所有信息*/
	/*button.onclick=function(){
		var Notice=document.getElementById("notice");
		var Song=document.createElement("div");
		Song.className="y_song";
		insertAfter(Song,Notice);

		var SongTitle=document.createElement("div");
		SongTitle.className="y_songTitle";
		Song.appendChild(SongTitle);

		var Img=document.createElement("img");
		Img.src="images/image.gif";
		SongTitle.appendChild(Img);

		var SongName=document.createElement("div");
		SongName.className="y_songName";
		SongName.innerHTML="演员——薛之谦";
		SongTitle.appendChild(SongName);

		var SongContent=document.createElement("div");
		SongContent.className="y-songcontent";
		Song.appendChild(SongContent);

		var PersonName=document.createElement("div");
		PersonName.className="y_personName";
		PersonName.innerHTML="点歌人:韩同学";
		SongContent.appendChild(PersonName);

		var ForPerson=document.createElement("div");
		ForPerson.className="y_forPerson";
		ForPerson.innerHTML="to:莫同学";
		SongContent.appendChild(ForPerson);

		var SongMessage=document.createElement("div");
		SongMessage.className="y_songMessage";
		SongMessage.innerHTML="lalalalalalalallalalalall";
		SongContent.appendChild(SongMessage);

		var Time=document.createElement("div");
		Time.className="y_time";
		Time.innerHTML="2016-11-13";
		SongContent.appendChild(Time);

	}

}*/


//定时刷新
// window.onload=function(){
// 	 var myrefresh=window.location.reload();

// setTimeout('myrefresh()',100000);

// }

//公告
/*$(document).ready(function(){
	//$('#TextTitle').empty();
	//$('#text').empty();//清除原有数据
	$.ajax({
		type:"GET",
		//公告
		url:"",
		data:'',
		success:function(data){
			var Notice=data.data;
			$('#TextTitle').text(data.title);
    		$('#text').text(data.text);
		}
	});
});*/
//歌单
$(document).ready(function(){
	$.ajax({
		type:"GET",
		//通过的
		url:"/song?action=findPassedSongs",
		data:'',
		/*success:function(data){
			var songData = data.data;
			var SongHtml='';
			for(var i=0;i<aongData.length;i++){
				SongHtml+="<div class='y_song'>"+
			"<div class='y_songTitle'>"+
			     "<img src='images/image.gif'>"+
			     "<div class='y_songName'>"+songData[i].songname+"-"+songData.pername+"</div>>"+
            "</div>"+
            "<div class='y-songcontent'>"+
            "<div class='y_personName'>点歌人:"+songData[i].name+"</div>"+
            "<div class='y_forPerson'>to:"+songData[i].for+"</div>"+
            "<div class='y_songMessage'>"+songData[i].message+"</div>"+
            "<div class='y_time'>"+songData[i].time+"</div>"+
            "</div>"+
		"</div>";}
		   $("#notice").after(SongHtml);
		}*/
	});
});