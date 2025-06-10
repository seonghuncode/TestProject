<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- JQUERY -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 
<!-- JQUERY-UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
 
<!-- bootstrap.min.css -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
 
<!-- bootstrap-theme.min.css -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
 
<!-- bootstrap.min.js -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>


<title>Insert title here</title>
</head>
<style>
.modal { top:60px; z-index: unset; position: relative!important; }
.modal-dialog { position: fixed; left: 0; right: 0; top: 100; margin: 70; padding: 10px;}
.modal-backdrop.in{opacity: 0;}

</style>

<script type="text/javascript">


//모달 위치 초기화 - 모달 창이 열리기 전에 실행
$(document).on('show.bs.modal', '.modal', function(){
	
    // 화면에 보여지는 모달수 추적
    if ( typeof( $('body').data( 'fv_open_modals' ) ) == 'undefined' ) {
        $('body').data( 'fv_open_modals', 0 );
    }

    // 이 모달의 z-index 속성이 정해져 있다면 무시
    if ($(this).hasClass('fv-modal-stack')) {
        return;
    }

    $(this).addClass('fv-modal-stack');
    $('body').data('fv_open_modals', $('body').data('fv_open_modals' ) + 1 );
    $(this).css('z-index', 1040 + (10 * $('body').data('fv_open_modals' )));
    $('.modal-backdrop').not('.fv-modal-stack').css('z-index', 1039 + (10 * $('body').data('fv_open_modals')));
    $('.modal-backdrop').not('fv-modal-stack').addClass('fv-modal-stack'); 
    
    // 모달 위치 초기화
    $(this).find($('.modal-dialog')).css('top',100);
    $(this).find($('.modal-dialog')).css('right',0);
    $(this).find($('.modal-dialog')).css('left',0);

    // 모달창 드래그 기능
    $(this).find($('.modal-dialog')).draggable({ handle: ".modal-header" });

})

// 모달창이 완전히 사라진 후 호출
$(document).on('hidden.bs.modal', '.modal', function(e){
    $(this).removeClass( 'fv-modal-stack' );
    $('body').data( 'fv_open_modals', $('body').data( 'fv_open_modals' ) - 1 );
});

// 클릭한 모달의 화면 우선순위
$(document).on('click', '.modal', function(){
    $(this).css('z-index', 1040 + (10 * $('body').data('fv_open_modals' )));  
    $('body').data('fv_open_modals', $('body').data('fv_open_modals' ) + 1 ); 
    
    if ( typeof( $('body').data( 'fv_open_modals' ) ) == 'undefined' ) {
        $('body').data( 'fv_open_modals', 0 );
    }
});

function test(){
	$("#dlgLineChart").modal('hide');

}

function test2(){
	$("#dlgPieChart").modal('hide');

}

</script>

<body>


<button type='button' data-toggle="modal" data-target="#first_modal">첫번쨰 모달 열기</button>
<button type='button' data-toggle="modal" data-target="#second_modal">두번쨰 모달 열기</button>
<button type='button' data-toggle="modal" data-target="#third_modal">세번쨰 모달 열기</button>
<!-- <button type='button' data-toggle="modal" data-target="#dlgLineChart">네번쨰 모달 열기</button>
<button type='button' data-toggle="modal" data-target="#dlgPieChart">다삿번쨰 모달 열기</button> -->
<button onclick="$('#dlgLineChart').modal('show')">라인 차트 열기</button>
<button onclick="$('#dlgPieChart').modal('show')">파이 차트 열기</button>
 
<!--first_modal-->
<!-- <div class="modal fade bs-example-modal-lg" id="first_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" data-backdrop="static"> -->
<div class="modal fade bs-example-modal-lg" id="first_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" data-backdrop="false">
<div class="modal-dialog modal-lg" role="document">
   <div class="modal-content">
     <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      
       <ol class="breadcrumb" style='background-color: white;'>
         <li><a href="#">모달</a></li>
         <li class="active">첫번쨰 모달</li>
       </ol>
     </div>
   </div>
</div>
</div>
 
<!--second_modal-->
<div class="modal fade bs-example-modal-lg" id="second_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" data-backdrop="false">
<div class="modal-dialog modal-lg" role="document">
   <div class="modal-content">
     <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      
       <ol class="breadcrumb" style='background-color: white;'>
         <li><a href="#">모달</a></li>
         <li class="active">두번쨰 모달</li>
       </ol>
     </div>
   </div>
</div>
</div>
 
<!--third_modal-->
<div class="modal fade bs-example-modal-lg" id="third_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" data-backdrop="false">
<div class="modal-dialog modal-lg" role="document">
   <div class="modal-content">
     <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      
       <ol class="breadcrumb" style='background-color: white;'>
         <li><a href="#">모달</a></li>
         <li class="active">세번쨰 모달</li>
       </ol>
     </div>
   </div>
</div>
</div>


<div id="dlgLineChart" class="modal fade" tabindex="-1" data-backdrop="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">Line Chart</div>
      <div class="modal-body">내용</div>
    <button id="modalHide" onclick="test();" >modal hide</button>
    </div>
  </div>
</div>

<div id="dlgPieChart" class="modal fade" tabindex="-1" data-backdrop="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">Pie Chart</div>
      <div class="modal-body">내용</div>
      <button id="modalHide" onclick="test2();" >modal hide</button>
    </div>
  </div>
</div>

</body>
</html>