<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看任务</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>

<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<div id="logo"><img src="../images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left.lbi" --><div id="left">
      <p><a href="taskview.html" target="_self">查看任务</a></p>
      <p><a href="task.html" target="_self">制定任务</a></p>
      <p><a href="taskundone.html" target="_self">调整任务</a></p>
      <p><a href="intendance.html" target="_self">跟踪任务</a></p>
      <p><a href="checkper.html" target="_self">查看人员</a></p>
      <p><a href="../login.html" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 查看任务 &gt;&gt; 任务信息</p>
        <h1>任务信息:</h1>
        <form action="taskparticular.html" method="post" name="form1" target="_self" id="form1">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">任务名称</td>
              <td width="15%" class="tdcolor">实施人</td>
              <td width="15%" class="tdcolor">开始时间</td>
              <td width="15%" class="tdcolor">结束时间</td>
              <td width="15%" class="tdcolor">任务状态</td>
              <td width="15%" class="tdcolor">计划数目</td>
              <td width="10%" class="tdcolor">&nbsp;</td>
            </tr>
            <tr>
              <td>任务一</td>
              <td>员工1</td>
              <td>2006-6-7</td>
              <td>2006- 7-6 </td>
              <td>实施中</td>
              <td>2</td>
              <td><input type="radio" name="radiobutton" value="radiobutton" /></td>
            </tr>
			<tr>
              <td>任务二</td>
              <td>员工2</td>
              <td>2006-6-7</td>
              <td>2006- 7-6 </td>
              <td>未实施</td>
              <td>0</td>
              <td><input type="radio" name="radiobutton" value="radiobutton" /></td>
			</tr>
          </table>
    <p>
              <label>
              <input name="Submit" type="submit" class="menu3" value="详细信息" />
            </label>
          </p>
      </form>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="../images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
