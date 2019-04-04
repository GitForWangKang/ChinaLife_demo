
function myFunction()
{
/*    var x,y,z;
    x = 1;
    y = 'String';
    z = ["username","phone","address"]
    userImformation = {username:userImformation}*/
    document.getElementById("demo").innerHTML="我的第一个 JavaScript 函数，引用外部js文件，静态资源扫描成功";
};

//输入检验
function validateForm() {
    var userName = document.forms["addUserImformation"]["userName"].value;
    var phone = document.forms["addUserImformation"]["phone"].value;
    var address = document.forms["addUserImformation"]["address"].value;

    if (userName == null || userName == "") {
        alert("需要输入名字。");
        return false;
    }

    if (phone == null || phone == "") {
        alert("需要输入电话号码。");
        return false;
    }

    if (address == null || address == "") {
        alert("需要输入地址。");
        return false;
    }

    $.ajax({
        type:"post",
        url:"/add",
        async:true,
        data:{"userName":userName,"phone":phone,"address":address},
        dataType:"json",
    })
}

//错误提示
function errorTips() {
    alert("此功能正在研发中，请勿使用")
    return false;
}

function queryUser() {
    console.log("测试")
    $.ajax({
        type : "post",
        url : "/josnQuery",
        dataType : "json",
        success:function(data){
            console.log(data)
            // alert("查询成功")
            drawTable(data.list);
        },
        error :function (e) {
            alert("查询失败")
        }
    })
}

function drawTable(data) {
    $('#example').DataTable({
        "paging": false ,
        "info": false,
        "order": [[ 0, "asc" ]],
        "lengthChange": false,
        "language": {
            "zeroRecords": "抱歉，无数据，请重新查询！",
            "lengthMenu": "每页显示_MENU_条",
            "paginate": {
                "next": "下一页",
                "previous": "上一页"
            },
            "info": "总共_TOTAL_条数据，目前显示的是第_START_到_END_条",
            "thousands": ","
        },
        // "iDisplayLength":25,
        "searching": false,
        "destroy": true,
        "data": data,
        scrollX: true,
        fixedColumns: {
            leftColumns: 1
        },
        "columns": [
            {
                "data": "adress",
                "title": "地址"
            },
            {
                "data": "phone",
                "title": "电话"
            },
            {
                "data": "username",
                "title": "姓名"
            }
        ]
    });
}
