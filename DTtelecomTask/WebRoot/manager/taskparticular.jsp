<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>任务详细信息</title>
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
        <p>您现在的位置 &gt;&gt; 查看任务 &gt;&gt; 任务详细信息</p>
        <h1>任务详细信息:</h1>

          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">任务名称</td>
              <td width="579" colspan="5">任务一</td>
            </tr>
            <tr>
              <td class="tdcolor">任务描述</td>
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr>
              <td class="tdcolor">开始时间</td>
              <td width="15%">2007-12-23</td>
              <td width="20%" class="tdcolor">结束时间</td>
              <td width="50%" colspan="3"><p>&nbsp;</p>              </td>
            </tr>
            <tr>
              <td class="tdcolor">实际开始时间</td>
              <td>&nbsp;</td>
              <td class="tdcolor">实际结束时间</td>
              <td colspan="3">&nbsp;</td>
            </tr>
            <tr>
              <td class="tdcolor">实施人</td>
              <td>&nbsp;</td>
              <td class="tdcolor">任务状态</td>
              <td>未完成</td>
              <td class="tdcolor">计划数目</td>
              <td>0</td>
            </tr>
        </table>
	    <form id="form1" name="form1" method="post" action="program.html">
		  <h1>实施计划：</h1>
		  <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="15%" class="tdcolor">完成状态</td>
              <td width="20%" class="tdcolor">是否反馈</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            <tr>
              <td>计划一</td>
              <td>已完成</td>
              <td>已反馈</td>
              <td>2006- 7-6 </td>
              <td>2007-3-24</td>
              <td><label>
                <input type="radio" name="radiobutton" value="radiobutton" />
              </label></td>
            </tr>
            <tr>
              <td>计划二</td>
              <td>未完成</td>
              <td>未反馈</td>
              <td>2006- 7-6 </td>
              <td>未实施</td>
              <td><label>
                <input type="radio" name="radiobutton" value="radiobutton" />
              </label></td>
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
