$(document).ready(function() {
            var form = $('#playerMoveForm');
            form.submit(function( event ) {
                var first = $("#first").val();
                var second = $("#second").val();
                $.ajax({
                    type: form.attr('method'),
                    url: form.attr('action'),
                    data: 'first=' + first + '&second=' + second,
                    success: function(test){
                        $('#Results').html('No problem').attr('class', 'info');
                        $('#boardcontainer').html(test);
                    },
                    error: function(){
                        $('#Results').html('This move is illegal').attr('class', 'info');
                    }
                })
                event.preventDefault();
            });
        });
