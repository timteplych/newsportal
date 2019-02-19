var articleBody="<div class='post_section'>"+"<h2><a class='article__title' href='{href}' >{article__title}</a></h2>"+"<strong>Дата: </strong><span class='article__date'>{adv__date}</span>|<strong>Автор: </strong><span class='article__author'>{adv__company}</span>"
    +"<p><div class='article__content'>{article__content}</div>"
    +"<div class='cleaner'></div>"
    +"<p><div class='category'>Категория: <span class='article__category'></span></div> <div class='button float_r'><a href=' ' class='more'>Читать далее</a></div>"+"<div class='cleaner'></div>"
    +"</div><div class='cleaner_h40'></div>";

//данные, которые передаются на сервер
//количество страниц
var number=5;
//порядок сортировки
var order="DESC";
//поле для сортировки
var orderBy="id";
//счетчик страниц(блоков)
var pageCounter=0;

//функция для размещения полученных данных на странице
function renderingAdvs(advs){
    advs.forEach(function(adv){
        var articleBodyCurr = articleBody;
        articleBodyCurr = articleBodyCurr.replace("{article__title}",adv["title"]);
        articleBodyCurr = articleBodyCurr.replace("{href}",contextPath+"/adv/"+adv["id"]);
        articleBodyCurr = articleBodyCurr.replace("{article__content}",adv["content"]);
        if(adv["publishedDate"]==null){
            articleBodyCurr = articleBodyCurr.replace("{adv__date}","---- -- --");
        }else{
            articleBodyCurr = articleBodyCurr.replace("{adv__date}",adv["publishedDate"]);
        }

        if(adv["company"]==null){
            articleBodyCurr = articleBodyCurr.replace("{adv__company}","");
        }else{
            articleBodyCurr = articleBodyCurr.replace("{adv__company}",adv["company"].title);
        }
        $(articleBodyCurr).appendTo("#templatemo_content")
    });
}

function loadAdvs() {
    data = "pageCounter="+pageCounter+"&"+"order="+order+"&"+"orderBy="+orderBy+"&"+"number="+number;
    $.ajax({
        url:url,
        type:'GET',
        data:data,
        cache:false,
        success: function (advsResponsive) {
            if(advsResponsive==0){
                alert("00000");
            }else{
                renderingAdvs(advsResponsive["advList"]);
                pagecounter++;
            }
        },

    });
}

$(document).ready(function () {
    loadAdvs();
    $(".btn_load").click(function () {
        loadAdvs();
    })
});