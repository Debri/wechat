$(document).ready(function () {
    //$('#TextTitle').empty();
    //$('#text').empty();//清除原有数据
    $.ajax({
        type: "GET",
        //公告
        url: "/song?action=masterFind",
        data: '',
        /*success:function(data){
         var Notice=data.data;
         $('#TextTitle').text(data.title);
         $('#text').text(data.text);
         }*/
    });
});

window.onload = function () {
    var pub = document.getElementById('publish');
    var part = document.getElementById('pub_part');
    pub.onclick = function () {
        pub.style.display = 'none';
        part.style.display = 'block';
    }
    pub.style.display = ' block';
    part.style.display = 'none';
    //确认发布判断函数开始
    var sure = document.getElementsByClassName('sure');
    sure[0].onclick = function () {
        var t_len = document.getElementsByClassName('title')[0].value.length;
        var c_len = document.getElementsByClassName('area')[0].value.length;
        if (t_len == 0 || t_len > 30) {
            alert("公告标题不能为空或超过30字");
        }
        else if (c_len == 0 || c_len > 200) {
            alert("公告内容不能为空或超过200字");
        }
        else {
           /* alert("恭喜你，公告发布成功！");*/
        }
    }
    //确认发布判断函数结束

    //取消发布
    var reset = document.getElementsByClassName('reset');
    reset[0].onclick = function () {
        pub.style.display = 'block';
        part.style.display = 'none';
    }

    $(".sure").click(function () {
        //alert("sub");
        $.ajax({
            //发公告
            url: '/announce?action=addAnnounce',
            type: "POST",
            data: $('form').serialize(),
            success: function() {
                /*$("#result").text(data);*/
                alert("发布成功");
            }

        });
    });

    //审核通过
    $('.pass').each(function () {
        $(this).click(function () {

            $.ajax({
                type: "POST",
                //将点歌状态设置为审核通过，但是未播
                url: "/song?action=doVerify",
                data: {id: $(this).next().val()},
                success : function () {
                    alert("审核成功");
                }
            });
        });
    })

    //歌曲已播
    $('.finish').each(function () {
        $(this).click(function () {
            $.ajax({
                type: "POST",
                //将点歌状态设置为审核通过，但是未播
                url: "/song?action=playSongs",
                data: {id: $(this).prev().val()},
                success : function () {
                    alert("播放成功");
                }
            });
        });
    })

    //删除点歌
    $('.delete').each(function () {
        $(this).click(function () {
            $.ajax({
                tpye : "POST",
                url: "/song?action=doDelete",
                data : {
                  id :  $(".del").val()
                },
                success : function () {
                    alert("删除成功");
                }
            })
        })
    })
}

