<!DOCTYPE html>
<html>
<#include "header.ftl">
<body id="page-top" class="landing-page">

<div>
    <form action = '/authenticate' method='POST'>
        <input type='text' name='username' id='username'/>
        <input type='password' name='password' id='password'/>
        <button type='submit'> LOGIN </button>
    </form>
</div>
<br>
<div>
    <form action = '/register' method='POST'>
        <input type='text' name='username2' id='username2'/>
        <input type='password' name='password2' id='password2'/>
        <button type='submit'> Register </button>
    </form>
</div>
<#include "/footer.ftl">

</body>
</html>