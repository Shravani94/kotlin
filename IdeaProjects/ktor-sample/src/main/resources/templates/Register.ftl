<#import "layout.ftl" as layout />
<@layout.header>
<form action="/hello" method="post">
<input type="text" value="firstname">
<input type="text" value="lastname">
<input type="button" value="submit">
</form>
</layout.header>
