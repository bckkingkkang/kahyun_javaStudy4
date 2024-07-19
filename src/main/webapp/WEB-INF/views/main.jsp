<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 사용 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>main</title>
    <style>
        .masonry {
            column-count: 5; /* 칼럼 수 */
            column-gap: 10px;
            width: 100%;
            max-width: 1500px;
        }

        /* 이미지 컨테이너 */
        .item {
            width: 100%;
            margin-bottom: 10px;
            display: inline-block;
            break-inside: avoid;
            border: solid #000000;
            /* 칸을 벗어나면 사진 잘림 */
            overflow: hidden;
            position: relative;
        }

        .item img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            position: absolute;
        }

        .size1 { height: 100px; }
        .size2 { height: 200px; }
        .size3 { height: 300px; }
        .size4 { height: 400px; }
        .size5 { height: 500px; }
    </style>
</head>
<body>
<div class="masonry">
    <%--
        items : collection 객체 (List, Map)
        var : 사용할 변수명
        varStatus : 반복 상태를 알 수 있는 변수
    --%>
    <c:forEach items="${image}" var="image" varStatus="status">
        <%--
            < varStatus >
            index : 리턴값(int) - items에 정의한 항목을 가리키는 index 번호로 0부터 시작한다.
            count : 리턴값(int) - 현재 몇 번째 반복인지 나타내며 1부터 시작한다.
            first : 리턴값(boolean) - 현재 반복이 첫번째인지 여부
            last : 리턴값(boolean) - 현재 반복이 마지막인지 여부
        --%>
        <c:choose>
            <%-- status.index(항목 순서)를 5로 나누었을 때를 기준으로 사진 크기 달라짐 --%>
            <c:when test="${status.index % 5 == 0}">
                <div class="item size1" ondrop="drop(event,${image.seq}, ${status.index+1})" ondragover="dragEnter(event)">
                    <img id="${image.seq}" src="/image/${image.image_name}" draggable="true" ondragstart="drag(event, ${image.location_num})">
                </div>
            </c:when>
            <c:when test="${status.index % 5 == 1}">
                <div class="item size2" ondrop="drop(event,${image.seq}, ${status.index+1})" ondragover="dragEnter(event)">
                    <img id="${image.seq}" src="/image/${image.image_name}" draggable="true" ondragstart="drag(event, ${image.location_num})">
                </div>
            </c:when>
            <c:when test="${status.index % 5 == 2}">
                <div class="item size3" ondrop="drop(event,${image.seq}, ${status.index+1})" ondragover="dragEnter(event)">
                    <img id="${image.seq}" src="/image/${image.image_name}" draggable="true" ondragstart="drag(event, ${image.location_num})">
                </div>
            </c:when>
            <c:when test="${status.index % 5 == 3}">
                <div class="item size4" ondrop="drop(event,${image.seq}, ${status.index+1})" ondragover="dragEnter(event)">
                    <img id="${image.seq}" src="/image/${image.image_name}" draggable="true" ondragstart="drag(event, ${image.location_num})">
                </div>
            </c:when>
            <c:otherwise>
                <div class="item size5" ondrop="drop(event,${image.seq}, ${status.index+1})" ondragover="dragEnter(event)">
                    <img id="${image.seq}" src="/image/${image.image_name}" draggable="true" ondragstart="drag(event, ${image.location_num})">
                </div>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

    // 드래그된 seq의 현재 자리(index) 저장
    var dragged_num;

    // dragEnter(ev) : 드래그된 요소가 드롭 영역으로 들어왔을 때 호출
    function dragEnter(ev) {
        // 이벤트 전파 방지(브라우저의 기본 동작 실행 X)
        ev.preventDefault();
    }

    // drag(ev) : 드래그가 시작될 때 호출, 드래그된 요소의 ID를 데이터 전송 객체에 저장
    function drag(ev, num) {
        ev.dataTransfer.setData("text", ev.target.id);
        dragged_num = num;
    }

    /* drop(ev) : 드롭될 때 호출, 드래그된 요소와 대상 요소를 서로 교환하여 드래그 앤 드롭 기능 구현 */
    function drop(ev, image_seq, index) {
        // 드롭 이벤트 기본 동작 방지
        ev.preventDefault();
        // 드래그 시작 시 저장된 데이터를 가져옴, 데이터는 'drag' 이벤트 핸들러에서 설정한 드래그된 요소의 id
        var data = ev.dataTransfer.getData("text");
        // 해당 id를 가진 요소를 가져옴, 드래그된 요소
        var draggedElement = document.getElementById(data);

        $.ajax({
            url : "/change_image",
            type : "post",
            data : {
                dragged_seq : data,
                dragged_num : dragged_num,
                dropped_seq : image_seq,
                dropped_num : index,
            },
            success :function() {
                location.reload();
            }
        })

        // 드롭 대상이 이미지인지 확인
        if (ev.target.tagName === "IMG") {
            /*
                targetElement : 드롭된 위치에 있는 이미지 요소
                targetParent : 드롭된 이미지의 부모 요소 (div.item)
                draggedParent : 드래그된 이미지의 부모 요소 (div.item)
            */
            var targetElement = ev.target;
            var targetParent = targetElement.parentNode;
            var draggedParent = draggedElement.parentNode;

            /*
                targetParentHeight : 드롭된 위치의 div.item 높이
                draggedParentHeight : 드래그된 이미지의 div.item 높이
            */
            var targetParentHeight = targetParent.clientHeight;
            var draggedParentHeight = draggedParent.clientHeight;

            /*
                targetParent.appendChild(draggedElement) : 드래그된 이미지를 드롭된 이미지의 부모 요소에 추가
                draggedParent.appendChild(targetElement) : 드롭된 이미지를 드래그된 이미지의 부모 요소에 추가
            */
            targetParent.appendChild(draggedElement);
            draggedParent.appendChild(targetElement);

            /* 드래그된 이미지의 높이를 드롭된 이미지의 부모 요소의 높이로 설정 */
            draggedElement.style.height = targetParentHeight + 'px';
            /* 드롭된 이미지의 높이를 드래그된 이미지의 부모 요소의 높이로 설정 */
            targetElement.style.height = draggedParentHeight + 'px';


        } else if (ev.target.classList.contains("item")) {  // 드롭된 위치가 div.item 인지 확인
            /*
               드롭 대상이 div.item 인 경우
            */
            var targetParent = ev.target; // 드롭된 위치의 div.item 요소

            /* 높이 계산 */
            var targetParentHeight = targetParent.clientHeight; // 드롭된 div.item 높이
            var draggedParentHeight = draggedElement.parentNode.clientHeight; // 드래그된 div.item 높이

            // 요소 추가 및 높이 조정
            targetParent.appendChild(draggedElement); // 드래그된 이미지를 드롭된 div.item에 추가
            draggedElement.style.height = targetParentHeight + 'px'; // 드래그된 이미지의 높이를 드롭된 div.item 높이로 설정
        }
    }
</script>
</body>
</html>
