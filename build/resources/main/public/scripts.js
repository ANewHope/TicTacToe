$(document).ready(function() {
            var form = $('#playerMoveForm');
            form.submit(function( event ) {
                var first = $("#first").val() - 1;
                var second = $("#second").val() - 1;
                $.ajax({
                    type: form.attr('method'),
                    url: form.attr('action'),
                    data: 'first=' + first + '&second=' + second,
                    success: function(test){
                        $('#Results').html('').attr('class', 'info');
                        $('#boardcontainer').html(test);
                    },
                    error: function(){
                        $('#Results').html('No way man!').attr('class', 'info');
                    }
                })
                event.preventDefault();
            });
        });

$(document).ready(function() {
            var reset = $('#resetForm');
            reset.submit(function( event ) {
                $.ajax({
                    type: reset.attr('method'),
                    url: reset.attr('action'),
                    success: function(test){
                        $('#boardcontainer').html(test);
                    },
                })
                event.preventDefault();
            });
        });
