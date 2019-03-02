
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
        error: function (){
          alert("error ajax");
        },
    });
}

$(document).ready(function () {
    loadAdvs();
    $(".btn_load").click(function () {
        loadAdvs();
    })
});