<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>未实施任务</title>
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
        <p>您现在的位置 &gt;&gt; 查看任务 &gt;&gt; 未实施任务信息</p>
        <h1>未实施任务信息:</h1>
        <form id="form1" name="form1" method="post" action="taskundone.html">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor"><a href="#" target="_self">任务名称</a></td>
              <td class="tdcolor"><a href="#" target="_self">实施人</a></td>
              <td class="tdcolor"><a href="#" target="_self">开始时间</a></td>
              <td class="tdcolor"><a href="#" target="_self">结束时间</a></td>
              <td class="tdcolor"><a href="#" target="_self">任务状态</a></td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            <tr>
              <td><a href="adjust.html">任务一</a></td>
              <td>员工1</td>
              <td>2006-6-7</td>
              <td>&nbsp;</td>
              <td>未实施</td>
              <td><label>
                <input type="checkbox" name="radiobutton" value="radiobutton" />
              </label></td>
            </tr>
			<tr>
              <td>任务二</td>
              <td>员工2</td>
              <td>2006-6-7</td>
              <td>&nbsp;</td>
              <td>未实施</td>
              <td><label>
                <input type="checkbox"  name="radiobutton" value="radiobutton" />
              </label></td>
            </tr>
          </table>
    <p>
            <label>
            <input name="Submit" type="submit" class="menu4" value="删除" />
            </label>
          </p>
      </form>
    </div>    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="../images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
