
<#import "pager.ftl" as pg/>
<@pg.page total=1000 pagenumber=1 pagesize=20/>
<div class="ui-gw-grid">
	<table cellpadding="1" border="0" cellspacing="1" >
		<tbody>
			<tr>
			  <td rowspan="2" class="ui-gw-info">
			    <div>
			      <div class="ui-gw-info-img-m ui-gw-info-img" style="float:left">&nbsp;</div>
			      <ul>
			        <li style="text-align: center"><span></span></li>
			        <li style="text-align: center"><span></span></li>
			        <li style="text-align: center"><span></span></li>
			      </ul>
			    </div>
			  </td>
			  <td > 
			    <ul class="ui-gw-person-toolbar-icon"> 
			      <li>
			        <a action="###" title=""><span class="ui-icon ui-icon-newwin" ></span></a>
			        <a action="###" title=""><span class="ui-icon ui-icon-carat-1-n" ></span></a>
			        <a action="###" title=""><span class="ui-icon ui-icon-triangle-1-w" ></span></a>
			        <input type="hidden" value="" class="id" />
			      </li>
			    </ul>
			  </td>
			</tr>
			<tr >
			  <td class="detail">
			    <ul class="ui-gw-person-summary">
			      <li>
			        <span><label>姓名:</label>${person.name}</span>
			        <span><label>性别：</label>${person.gender}</span>			        
			      </li>
			    </ul>                
			  </td>
			</tr>
		</tbody>
	</table>
</div>