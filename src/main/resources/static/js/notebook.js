"use strict";

$(function () {
    setSearchValue();
    historySearch();
    searchCheck();
    editNote();
    delNote();
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
    $(".note-list").click(function () {
        $(".search-input").val($(this).find("span").first().text());
        $(".search-form").submit();
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

function editNote() {
    $(".edit-note-btn").click(function () {
        let language = $("#query-to-menu >li[class=active] > a").attr("to-type-id");
        let word = $(".search-input").val();

        window.location.href = $("#APP_PATH").attr("href") + "/noteEdit/editPage?language=" + language + "&word=" + word;
    });
}

function delNote() {
    $(".del-note-btn").click(function () {
        if (confirm("你确定要删除 " + $(".word-name").text() + " 吗?")) {
            let word = $(".search-input").val();

            window.location.href = $("#APP_PATH").attr("href") + "/noteEdit/deleteNote?word=" + word;

            return true;
        } else {
            return false;
        }
    });
}