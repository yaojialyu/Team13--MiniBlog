<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>TEAM 13 Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>

<body>
<div class="cloud"></div>

<div class="register"> 
<h1>TEAM 13 - MiniBlog</h1>
<h2>Sign up</h2>
<div id="right_top"><a href="index.jsp">Sign in</a></div>
	<div class="sign_up_info">
	&nbsp;
	<form method="post" action="SignupSVL">
		<table>
			<tr>
				<td style="height: 31px">Emali</td> 
				<td style="height: 31px; width: 184px;"><input name="email" type="text" /></td>
				<td style="width: 206px; height: 31px;"><a>Please type in your E-mail adress</a></td>
			</tr>
			<tr>
				<td>Password</td>
				<td style="width: 184px"><input name="password" type="password" /></td>
				<td style="width: 206px"><a>Please type in your password</a></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td style="width: 184px"><input name="Password2" type="password" /></td>
				<td style="width: 206px"><a>Confirm your password</a></td>
			</tr>
			<tr>
				<td>Nickname</td>
				<td style="width: 184px"><input name="Nickname" type="text" /></td>
				<td style="width: 206px"><a>Please type in your Nickname</a></td>
				<td></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td style="width: 184px">
				<input checked="checked" name="gender" type="radio" value="0" />Male
				<input name="gender" type="radio" value="1" />Female</td>
				<td style="width: 206px"><a>Please choose your gender</a></td>
			</tr>

			<tr>
				<td>City</td>
				<td style="width: 184px"><input name="city" type="text" /></td>
				<td style="width: 206px"><a>Please type in your city</a></td>
			
			</tr>
			<tr>
				<td>AvatarURL</td>
				<td style="width: 184px"><input name="avatar" type="text" /></td>
				<td style="width: 206px"><a>Please type in your avatar URL</a></td>
			
			</tr>

		</table>
		<div style="margin-left:200px; margin-top:20px;">
						
				<input class="button" name="sign_up" type="submit" value="Sign up" style="height: 34px; width: 114px;margin-top:40px; margin-left:10px;" />&nbsp;&nbsp;
				<input class="button" name="Button1" type="reset" value="Reset"  style="height: 34px; width: 114px;margin-top:40px;"  />
				
		</div>
	</form>
	

	</div>

</div>

</body>

</html>
