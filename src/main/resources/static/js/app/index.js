//var index란 객체를 만들어 해당 객체에서 필요한 모든 function을 선언하는 것이다.
//이렇게 하면 index 객체 안에서만 function이 유효하기 때문에 다른 JS와 겹칠 위험이 사라진다.
var index = {
    init : function () {
        var _this = this;
        console.log("_this : " + _this);
        $('#btn-save').on('click', function(){
            _this.save();
        });
        $('#btn-update').on('click', function(){
            _this.update();
        });
        $('#btn-delete').on('click', function(){
            _this.delete();
        });
    },
    save : function () {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href= '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

index.init();