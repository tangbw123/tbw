<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分配人员</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>

<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<div id="logo"><img src="../images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left3.lbi" -->
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<div id="left2">
      <p><a href="useradmin.html" target="_self" >用户管理</a></p>
      <p><a href="empadmin.html" target="_self">员工管理</a></p>
      <p><a href="empdistribute.html" target="_self">分配人员</a></p>
      <p ><a href="../login.html" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 分配人员</p>
        <h1>用户详细信息:</h1>
		<form id="form0" name="form1" method="post" action="useradmin.html">
        <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
          <tr>
            <td class="tdcolor">用户名称</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="15%" class="tdcolor">真实姓名</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">行业角色</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">性&nbsp;&nbsp;&nbsp; 别</td>
            <td>男</td>
          </tr>
          <tr>
            <td class="tdcolor">入职时间</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">职位信息</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">出生年月</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">学历信息</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">专业信息</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">行业经验</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="tdcolor">上级主管</td>
            <td><label>
              <select name="select">
                <option value="主管一">主管一</option>
                <option value="主管二">主管二</option>
              </select>
            </label></td>
          </tr>
        </table>
        <p>&nbsp;</p>

          <p>
            <input name="Submit" type="reset" class="menu2" value="取消" />
            <label>
            <input name="Submit2" type="submit" class="menu1" value="提交" />
            </label>
          </p>
      </form>
    </div>    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="../images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
