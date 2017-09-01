<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="profileHeader.jsp" %>

<div class="mainContent">

<div class="content">

	<div class="profile_content">
		<div class="test_header"><p style="font-size: 40px;color: #4F4F51;">TEST-SERIES</p></div>
		<div class="test_note">
				<fieldset id="test_notice">
					<legend style="color:#4F4F51;font-size: 14px;">NOTE : </legend>
    					<ul style="font-size: 14px;color:#4F4F51;">
    						<li>~ You can give test only once, but you can access it anytime.</li>
    						<li>~ once you requested a test, you will get a test-id throught you can access it.</li>
    						<li>~ You can pass a test only when you get scored more than test-passing-marks.</li>
    						<li>~ once you requested a test, you will get a test-id throught you can access it.</li>
    					</ul>
				</fieldset>
		</div>
		
		<div class="test_list">
		<div class="datagrid">
		<table>
			<thead>
				<tr>
					<th>Subject</th>
					<th>ID</th>
					<th>Test level</th>
					<th>Passing marks</th>
					<th>Time limit</th>
					<th>No. of que</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="6">
						<div id="paging">
							<ul>
								<li><a href="#"><span>Previous</span></a></li>
								<li><a href="#" class="active"><span>1</span></a></li>
								<li><a href="#"><span>2</span></a></li>
								<li><a href="#"><span>3</span></a></li>
								<li><a href="#"><span>4</span></a></li>
								<li><a href="#"><span>5</span></a></li>
								<li><a href="#"><span>Next</span></a></li>
							</ul>
						</div>
					</td>
				</tr>
			</tfoot>
			<tbody>
			<c:set var="columnNumber" value="${1}" />
			 <c:forEach items="${testList}" var="current">
			 <c:if test="${columnNumber % 2 == 1}">
        <tr>
          <td><c:out value="${current.subject}" /><td>
          <td><c:out value="${current.testId}" /><td>
          <td><c:out value="${current.level}" /><td>
          <td><c:out value="${current.mm}" /><td>
          <td><c:out value="${current.time}" /><td>
          <td><c:out value="${current.noOfQue}" /><td>
        </tr>
        </c:if>
        <c:if test="${columnNumber % 2 == 0}">
        <tr class="alt">
          <td><c:out value="${current.subject}" /><td>
          <td><c:out value="${current.testId}" /><td>
          <td><c:out value="${current.level}" /><td>
          <td><c:out value="${current.mm}" /><td>
          <td><c:out value="${current.time}" /><td>
          <td><c:out value="${current.noOfQue}" /><td>
        </tr>
        </c:if>
      </c:forEach>
			
			</tbody>
		</table>
		</div>
		</div>
</div>
</div>
</div>

<%@ include file="footer.jsp" %>
