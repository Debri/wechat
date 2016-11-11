window.onload = function () {
    var Name = document.getElementById("Name");//用户名
    var SongName = document.getElementById("songName");//歌名
    var PersonName = document.getElementById("personName");//歌手
    var ForName = document.getElementById("forName");//to:
    var Message = document.getElementById("message");
    var NameIimit = document.getElementById("NameIimit");
    var SongNameIimit = document.getElementById("songNameIimit");//歌名限制信息
    var PersonNameIimit = document.getElementById("personNameIimit");//歌手信息限制
    var FornameIimit = document.getElementById("forNameIimit");//点歌对象信息限制
    var MessageIimlt = document.getElementById("massageIimit");//寄语信息限制
    var SongSubmit = document.getElementById("songSubmit");
    var NameSwitch;
    var SongNameSwitch;
    var PersonNameswitch;
    var ForNameswitch;
    var Messageswitch;
    //获取字符串长度
    function strlen(str) {
        var len = 0;
        for (var i = 0; i < str.length; i++) {
            var c = str.charCodeAt(i);
            //单字节加1
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                len++;
            }
            else {
                len += 2;
            }
        }
        return len;
    }

    //用户名限制
    Name.onblur = function () {
        if (strlen(Name.value) > 20) {
            NameIimit.style.display = "block";
        } else if (strlen(Name.value) == 0) {
            NameIimit.style.display = "block";
            NameIimit.innerHTML = "不能为空";
        } else {
            NameIimit.style.display = "none";
            NameSwitch = true;
        }
    }

    //歌名限制
    SongName.onblur = function () {
        if (strlen(SongName.value) > 40) {
            SongNameIimit.style.display = "block";
        } else if (strlen(SongName.value) == 0) {
            SongNameIimit.style.display = "block";
            SongNameIimit.innerHTML = "不能为空";
        } else {
            SongNameIimit.style.display = "none";
            SongNameSwitch = true;
        }
    }
    //歌手姓名限制
    PersonName.onblur = function () {
        if (strlen(PersonName.value) > 20) {
            PersonNameIimit.style.display = "block";
        } else if (strlen(PersonName.value) == 0) {
            PersonNameIimit.style.display = "block";
            PersonNameIimit.innerHTML = "不能为空";
        }
        else {
            PersonNameIimit.style.display = "none";
            PersonNameswitch = true;
        }
    }

    //点歌对象限制
    ForName.onblur = function () {
        if (strlen(ForName.value) > 20) {
            FornameIimit.style.display = "block";
        } else if (strlen(PersonName.value) == 0) {
            FornameIimit.style.display = "block";
            FornameIimit.innerHTML = "不能为空";
        }
        else {
            FornameIimit.style.display = "none";
            ForNameswitch = true;
        }
    }

    //寄语信息限制
    Message.onfocus = function () {
        MessageIimlt.style.display = "block";
        MessageIimlt.style.color = "#0078D7";
    }
    Message.onkeyup = function () {
        inputLength = Message.value.length;
        restLength = 50 - inputLength;
        MessageIimlt.innerHTML = "已输入" + inputLength + "个字，还可输入" + restLength + "个字";
        if (restLength == 0) {
            MessageIimlt.style.color = "#ee4242";
            MessageIimlt.innerHTML = "字数已超出"
        } else if (restLength > 0) {
            Messageswitch = true;
        }
    }
    //表单提交
    SongSubmit.onclick = function () {
        console.log($('#form').serialize());
        if (Messageswitch && ForNameswitch && PersonNameswitch && SongNameSwitch && NameIimit) {
            $.ajax({
                //url: 'demo.php',
                url: '/song?action=addSong',
                type: "POST",
                data: $('#form form').serialize(),
                // success: function(data) {
                //     $("#result").text(data);
                // }
            });
        } else {
            alert("提交不成功");
        }
    }



}

