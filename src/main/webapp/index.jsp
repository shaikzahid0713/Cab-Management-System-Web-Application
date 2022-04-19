<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel = "stylesheet" href = "style.css" type = "text/css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<link rel="stylesheet" href="logout.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<div class=" d-flex justify-content-between nav-color">
        <h2 class="nav-logo ">
            S.
        </h2>
        <!-- <form>
            <button class="btns" type="submit">Logout</button>
        </form> -->

    </div>


    <div class="bg-container">
<div class="wrapper">
	<div class="container">
		<h1 style="font-weight: 600;">Welcome</h1>
		
		<form class="form" action="rose" method="post">
			<select class="select" name="dropdown">
			<option value="1" class="p_select">Employee</option>
			<option value="2" class="p_select">Manager</option>
			<option value="3" class="p_select">Admin</option>
			</select>
			<input type="email" placeholder="Email" name="id">
			<input type="password" placeholder="Password" name="ipass">
			<button type="submit" id="login-button" onclick="openWeb()">Login</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
</div>


    <div class="copyright-container">
        <div class=" d-flex flex-row justify-content-center">
            <i class="fa fa-copyright icon" aria-hidden="true"></i>
            <p class="content ml-2">Made with <b style="color: red;">&#x2764;&#xfe0f;</b> by Sagnik.</p>
        </div>
    </div>
</body>
</html>