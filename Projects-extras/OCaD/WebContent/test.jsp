<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Test</title>
<!-- SET: FAVICON -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!-- END: FAVICON -->
<!-- SET: STYLESHEET -->
<link href="css/home.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/test.css" rel="stylesheet" type="text/css" media="all" />
<%@ include file="homeHeader.jsp" %>
<div class="testMainContent">

<div class="testContent">

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
					<th style="width:250px;">Subject</th>
					<th style="width:150px;">ID</th>
					<th style="width:100px;">Test level</th>
					<th style="width:100px;">Passing %</th>
					<th style="width:100px;">Time limit</th>
					<th style="width:100px;">No. of que</th>
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
			<%-- <c:set var="columnNumber" value="${1}" /> --%>
			 <c:forEach items="${testList}" var="current" varStatus="columnNumber">
			 <c:if test="${columnNumber.count % 2 == 1}">
        <tr class="first">
          <td><a href="conductTest<c:out value="${current.testUrl}" />" ><c:out value="${current.testId}" /></a></td>
          <td><c:out value="${current.subject}" /></td>
          <td><c:out value="${current.level}" /></td>
          <td><c:out value="${current.mm}" /></td>
          <td><c:out value="${current.time}" /></td>
          <td><c:out value="${current.noOfQue}" /></td>
        </tr>
        </c:if>
        <c:if test="${columnNumber.count % 2 == 0}">
        <tr class="alt">
          <td><a href="conductTest<c:out value="${current.testUrl}" />" ><c:out value="${current.testId}" /></a></td>
          <td><c:out value="${current.subject}" /></td>
          <td><c:out value="${current.level}" /></td>
          <td><c:out value="${current.mm}" /></td>
          <td><c:out value="${current.time}" /></td>
          <td><c:out value="${current.noOfQue}" /></td>
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