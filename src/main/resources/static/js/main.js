"use strict";

$(function () {
    setSearchValue();
    historySearch();
    historyDelete();
    searchCheck();
});

/*给搜索的from和to隐藏域赋值*/
function setSearchValue() {
    $("#choose-from").text($(".from-type-choosed > a").text());

    $("#query-from-menu>li").click(function () {
        $(this).siblings('li').removeClass('from-type-choosed');
        $(this).addClass("from-type-choosed");
        $("#from").val($(this).attr("from-type-code"));
        $("#choose-from").text($(".from-type-choosed > a").text());
    });


    $("#query-to-menu>li").click(function () {
        $(this).siblings('li').removeClass('active');
        $(this).addClass("active");
        $("#to").val($(this).find("a").attr("to-type-code"));
    });
}

function historySearch() {
    $(".history-list").click(function () {
        $(".search-input").val($(this).find("span").first().text());
        $(".search-form").submit();
    });
}

function historyDelete() {
    $(".history-list > button").click(function (e) {
        e.stopPropagation();//阻止事件冒泡即可

        window.location.href = $("#APP_PATH").attr("href") + "translate/delHistory?id=" + $(this).attr("history-id") + "&index=" + $(this).attr("history-index");
    });
}

function searchCheck() {
    $(".search-form > button").click(function () {
        let val = $(".search-input").val();
        if (!val) {
            alert("请输入待查询的文字!")
            return false;
        }
    });
}
