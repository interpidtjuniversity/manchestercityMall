$(function() {
  var mySwiper = new Swiper("#homeSwiper-container", {
    loop: true,
    autoplay: {
      delay: 3500,
      disableOnInteraction: false
    }, //可选选项，自动滑动
    speed: 1000,
    effect: "fade",
    hideOnClick: true,
    pagination: {
      el: ".swiper-pagination"
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
      hideOnClick: true
    }
  });
  var swiper = new Swiper("#recommend-container", {
    loop: true,
    autoplay: {
      delay: 3500,
      disableOnInteraction: false
    }, //可选选项，自动滑动
    slidesPerView: 5,
    spaceBetween: 30,
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
      hideOnClick: true
    }
  });

  const $shoppingCartA = $("#shoppingCartA");
  const $shoppingCartList = $("#shoppingCartList");
  const $headerNavA = $("#header-nav>a");
  const $navMenu = $("#navMenu");
  let setTimeoutMap = new Map();

  $shoppingCartA.hover(
    function() {
      this.classList.add("shoppingCartA-active");
      $shoppingCartList.slideDown(200);
    },
    function() {
      let a = setTimeout(() => {
        this.classList.remove("shoppingCartA-active");
        $shoppingCartList.slideUp(200);
      }, 200);
      setTimeoutMap.set("shoppingCartList", a);
    }
  );

  $shoppingCartList.hover(
    function() {
      // over
      clearTimeout(setTimeoutMap.get("shoppingCartList"));
    },
    function() {
      // out
      $shoppingCartA.removeClass("shoppingCartA-active");
      $shoppingCartList.slideUp(200);
    }
  );
  $headerNavA.hover(
    function() {
      // over
      let displayType = $navMenu.css("display");
      let type = $(this).data("type");
      console.log(type);
      if (type) {
        if (displayType === "none") {
          $navMenu.slideDown(500);
        } else {
          clearTimeout(setTimeoutMap.get("navMenu"));
        }
      }
    },
    function() {
      // out
      let displayType = $navMenu.css("display");
      if (displayType === "block") {
        let a = setTimeout(() => {
          $navMenu.slideUp(500);
        }, 200);
        setTimeoutMap.set("navMenu", a);
      }
    }
  );

  $navMenu.hover(
    function() {
      // over
      clearTimeout(setTimeoutMap.get("navMenu"));
    },
    function() {
      // out
      let displayType = $navMenu.css("display");
      if (displayType === "block") {
        let a = setTimeout(() => {
          $navMenu.slideUp(500);
        }, 200);
        setTimeoutMap.set("navMenu", a);
      }
    }
  );

  $("#search-input")
    .focus(function(e) {
      e.preventDefault();
      $("#search").css("border-color", "var(--orange)");
      $("#search-right").css("border-color", "var(--orange)");
      $("#search>a").css("display", "none");
      $("#search-list").slideDown();
    })
    .blur(function(e) {
      e.preventDefault();
      $("#search").css("border-color", "var(--grey)");
      $("#search-right").css("border-color", "var(--grey)");
      $("#search>a").css("display", "block");
      $("#search-list").slideUp();
    });

  const $categoryListShow = $("#categoryList-show");
  let categoryListMainLi;
  $("#category-list-main>li").hover(
    function() {
      // over
      categoryListMainLi = this;
      categoryListMainLi.style.backgroundColor = "var(--white)";
      let visibility = $categoryListShow.css("visibility");
      if (visibility === "hidden") {
        $categoryListShow.css("visibility", "visible");
      } else {
        clearTimeout(setTimeoutMap.get("categoryListShow"));
      }
    },
    function() {
      // out
      categoryListMainLi.style.backgroundColor = "initial";
      let a = setTimeout(() => {
        $categoryListShow.css("visibility", "hidden");
      }, 200);
      setTimeoutMap.set("categoryListShow", a);
    }
  );

  $categoryListShow.hover(
    function() {
      // over
      categoryListMainLi.style.backgroundColor = "var(--white)";
      clearTimeout(setTimeoutMap.get("categoryListShow"));
    },
    function() {
      // out
      categoryListMainLi.style.backgroundColor = "initial";
      let a = setTimeout(() => {
        $categoryListShow.css("visibility", "hidden");
      }, 200);
      setTimeoutMap.set("categoryListShow", a);
    }
  );
});


/*
* 悬浮时弹出购物车图标 预加入购物车
* */
function preAddCart(id) {
  if(idFlagArray[id-1]===0) {
    var addBtnId = "addBtn"+String(id);
    var addBtn = document.getElementById(addBtnId);
    addBtn.src = "./images/dynamic/addCart.png";
    //addBtn.style.display = 'block';

    addBtn.onclick = function(){
      //发送ajax请求
      var xhr = new XMLHttpRequest();
      xhr.open("POST","http://47.114.153.37:9999/action/userCart/addCart",true);
      xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
      var body = "goodId="+String(id);
      xhr.withCredentials = true;
      xhr.send(body);
      xhr.onreadystatechange = function (e) {
        if (xhr.readyState === 4 && xhr.status === 200) {
          var data = JSON.parse(xhr.responseText);
          if(data.opRes === "success"){
            alert("加入购物车成功!")
          }
          else if(data.opRes === "unauthorized"){
            alert("请先登陆!")
          }
          else if(data.opRes === "limited"){
            alert("操作太快了,休息一下!")
          }
        }
      };

    };
    idFlagArray[id-1]=1;
  }
}

/*
* 取消悬浮时删除添加购物车图标
* */
function cancelAddCart(id) {
  if(idFlagArray[id-1]===1) {
    var addBtnId = "addBtn"+String(id);
    var addBtn = document.getElementById(addBtnId);
    addBtn.src = "";
    //addBtn.style.display = 'none';
    idFlagArray[id-1]=0;
  }
}

function sleep (time) {
  return new Promise((resolve) => setTimeout(resolve, time));
}

function gotoCart() {
  //发送ajax请求
  var xhr = new XMLHttpRequest();
  xhr.open("POST","http://47.114.153.37:9999/action/userCart/cartVerify",true);
  xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  xhr.withCredentials = true;
  xhr.send(null);
  xhr.onreadystatechange = function (e) {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var data = JSON.parse(xhr.responseText);
      if(data.opRes === "success"){
        window.location.href="cart.html";
      }
      else if(data.opRes === "unauthorized"){
        alert("请先登陆!");
      }
    }
  };

}

function gotoOrder() {
  //发送ajax请求
  var xhr = new XMLHttpRequest();
  xhr.open("POST","http://47.114.153.37:9999/action/order/orderVerify",true);
  xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  xhr.withCredentials = true;
  xhr.send(null);
  xhr.onreadystatechange = function (e) {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var data = JSON.parse(xhr.responseText);
      if(data.opRes === "success"){
        window.location.href="orders.html";
      }
      else if(data.opRes === "unauthorized"){
        alert("请先登陆!");
      }
    }
  };

}


