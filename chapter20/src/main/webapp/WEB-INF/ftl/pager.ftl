<#macro page  total=0 pagesize=20 pagenumber=1>
<div class="gw-ui-pager">
	<div id="checkAll"><span>全选</span></div>
	<div class="ui-gw-pager-total">
	    <span>共有数据 </span>
	    <span class="ui-gw-pager-totalcount">${total}</span>
	    <span>条</span>
	</div>
	<div class="ui-gw-pager-total">
	    <span>每页</span>
	    <input 	class="input ui-gw-pager-pagesize" style="width:25px;height:10px;" type="text" value="${pagesize}">
	    <span>条</span>
	</div>
	<div class="ui-gw-pager"></div>
</div> 
</#macro>