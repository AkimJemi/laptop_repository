document.addEventListener('DOMContentLoaded', function() {
		var result;
	    var calendarEl = document.getElementById('calendar');
	    var calendar = new FullCalendar.Calendar(calendarEl,
			{
				initialView : 'dayGridMonth',
				locale: 'ja',
				selectable: true,
				headerToolbar : {
				center : 'addEventButton'
				}, events : [
					<%int i = 0;
						for (BookingsDTO bookInfo : bookList) {
							String color ="", textColor ="", title ="";
							title = bookInfo.getRoomName() + " - " + bookInfo.getUserName();
							if(bookInfo.isDeleteFlag()){
								color = "red";
								textColor = "white";
							} else if(bookInfo.isCancelFlag()){
								color = "orange";
								textColor = "black";
							} else if(bookInfo.isPayFlag()){
								color = "yellow";
								textColor = "orange";
							}
								
							if (!bookList.isEmpty()) {%>
								{
									title : '<%=title%>',
									start : '<%=bookInfo.getStartDate()%>',
									end : '<%=bookInfo.getEndDate()%>',
									url: '/admin/book/detail/<%=bookInfo.getId()%>',
									color : '<%=color%>', 
									textColor : '<%=textColor%>' 
								},
							<%} else {%>
				 				{
									title : '<%=title%>',
									start : '<%=bookInfo.getStartDate()%>',
									end : '<%=bookInfo.getEndDate()%>',
									url: '/admin/book/detail/<%=bookInfo.getId()%>',
									color : '<%=color%>',
									textColor : '<%=textColor%>' 
								},
							<%}
						}%>  
					]
				 , dateClick: function(info) {
					console.log("dateClick : " + info.dateStr);
				} , select: function(info){
					console.log("select : " + info.startStr + " - " + info.endStr);
					checkDateAvailable(info.startStr, info.endStr);
				}
	    });
	    function checkDateAvailable(str, end){
	    	$.ajax({
	    		type:'POST',
	    		url:'calendarSelect',
	    		data:{"startDate": str, "endDate": end, "id": 90},	
	    		dataType:'json',
	    		async:false
	    	})
	    	.done(function(data){
	    		if(data.result == true){
	    		result = 'yes';
	    		}else {
	    		result = 'no';
	    		};
	    		alert(data.message);
	    	})
	    	.fail(function(request, status, error){
	    		alert("エラー　：　" + error);
	    	})
	    };
	    calendar.render();
	  }); 