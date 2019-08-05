$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function formValid() {
    userName = $("#myform input[name=user]").val();
    content = $("#myform textarea[name=content]").val();
    if (userName == '张月琴')
        $("#hitspan").html("<b>"+userName + "</b>,是我媳妇");
    else if (userName.indexOf("倩") > -1 || userName.indexOf("qian") >-1 || userName.indexOf("雪") >-1|| userName.indexOf("梦") >-1)
        $("#hitspan").text("你的名有我喜欢的字");
    if (userName == "" || content == "")
        return false;
    return true;
}

function hip(message) {
    $('#modelDialog').modal({
        show: true
    });
    $('#modelDialog').find('.modal-body').text(message);
}