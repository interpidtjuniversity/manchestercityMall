function showCart(data) {
    let order_content = document.getElementById("order_content_id");

    for(let index = 0;index<data.length;index++) {
        let order_lists = document.createElement("ul");
        order_lists.className = "order_lists";
        let num = data[index]['goodId'];

        // id
        let list_price = document.createElement("li");
        list_price.className = "list_price";
        let div = document.createElement("div");
        div.style.textAlign = "center";
        div.style.paddingTop = "60px";
        let a = document.createElement("a");
        a.innerHTML = num;
        div.appendChild(a);
        list_price.appendChild(div);
        order_lists.appendChild(list_price);

        // img
        let img_list = document.createElement("li");
        img_list.className = "list_con";
        let div2 = document.createElement("div");
        div2.className = "list_img";
        div2.style.display = "inline";
        let img = document.createElement("img");
        img.src = "./images/hot/img" + num + ".png";
        div2.appendChild(img);
        let div3 = document.createElement("div");
        div3.className = "list_text";
        div3.style.display = "inline";
        div3.style.width = "100px";
        div3.style.paddingTop = "35px";
        div3.innerHTML = data[index]['goodMessage'];
        img_list.appendChild(div2);
        img_list.appendChild(div3);
        order_lists.appendChild(img_list);

        // fa huo di
        let send = document.createElement("li");
        send.className = "list_price";
        let div4 = document.createElement("div");
        div4.style.textAlign = "center";
        div4.style.paddingTop = "60px";
        div4.innerHTML = data[index]['goodDeliveryPlace'];
        send.appendChild(div4);
        order_lists.appendChild(send);

        // price
        let total_price = document.createElement("li");
        total_price.className = "list_price";
        let p = document.createElement("p");
        p.className = "price";
        p.style.textAlign = "center";
        p.style.paddingTop = "40px";
        p.innerHTML = data[index]['goodPrice'];
        total_price.appendChild(p);
        order_lists.appendChild(total_price);

        // total num
        let list_amount = document.createElement("li");
        list_amount.className = "list_amount";
        list_amount.style.paddingLeft = "8px";
        let div5 = document.createElement("div");
        div5.className = "amount_box";
        div5.style.paddingTop = "40px";
        let text = document.createElement("input");
        text.value = data[index]['goodNum'];
        text.type = "text";
        text.className = "sum";
        div5.appendChild(text);
        list_amount.appendChild(div5);
        order_lists.appendChild(list_amount);

        // list_sum
        let list_sum = document.createElement("li");
        list_sum.className = "list_sum";
        let p2 = document.createElement("p");
        p2.className = "sum_price";
        p2.style.textAlign = "center";
        p2.innerHTML = (data[index]['goodPrice']*data[index]['goodNum']).toString();
        p2.style.paddingTop = "40px";
        list_sum.appendChild(p2);
        order_lists.appendChild(list_sum);
        order_content.appendChild(order_lists);

    }
}

function cashIn() {
    var datas=[];

    for(let index=0; index<dataOrder.length;index++){
        var data = {};
        data["goodId"] = dataOrder[index]['goodId'];
        data["goodNum"] = dataOrder[index]['goodNum'];
        data["goodDeliveryPlace"] = dataOrder[index]['goodDeliveryPlace'];
        data["totalPrice"] = dataOrder[index]['goodNum'] * dataOrder[index]['goodPrice'];
        datas.push(data);
    }
    var orderString = JSON.stringify(datas);
    orderString = "orders="+orderString+"";
    //发送ajax请求下单
    var xhr = new XMLHttpRequest();
    xhr.open("POST","http://47.114.153.37:9999/action/order/saveOrders",true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.withCredentials = true;
    xhr.send(orderString);
    xhr.onreadystatechange = function (e) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var data = JSON.parse(xhr.responseText);
            if(data.opRes === "success"){
                alert("下单成功!");
            }
            else if(data.opRes === "unauthorized"){
                alert("请先登陆!");
                window.location.href="login.html";
            }
        }
    };

    var cart = document.getElementById("order_content_id");
    cart.innerHTML = "";
    //发送ajax清空购物车
    var xhr1 = new XMLHttpRequest();
    xhr1.open("POST","http://47.114.153.37:9999/action/userCart/clearCart",true);
    xhr1.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr1.withCredentials = true;
    xhr1.send(null);
    xhr1.onreadystatechange = function (e) {
        if (xhr1.readyState === 4 && xhr1.status === 200) {
            var data = JSON.parse(xhr1.responseText);
            if(data.opRes === "success"){
                alert("购物车已清空");
            }
            else if(data.opRes === "unauthorized"){
            }
        }
    };

}

function getOrder() {
    var xhr1 = new XMLHttpRequest();
    xhr1.open("GET","http://47.114.153.37:9999/action/order/getOrders",true);
    xhr1.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr1.withCredentials = true;
    xhr1.send(null);
    xhr1.onreadystatechange = function (e) {
        if (xhr1.readyState === 4 && xhr1.status === 200) {
            var data = JSON.parse(xhr1.responseText);
            if(data.opRes === "success"){
                alert(data.dataRes);
            }
            else if(data.opRes === "unauthorized"){
            }
        }
    };
}

function back() {
    window.location.href="index.html";
}