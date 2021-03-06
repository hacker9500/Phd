<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container-fluid">
  <form class="form-horizontal" role="form" action="tab3" method="post">
  <div class="well well-lg">You can pay the application fee of INR 350 online using Credit/Debit card or NetBanking.</div>
  <button type="submit" class="btn btn-success" id="payCard">Pay using Debit/Credit Card or Net Banking</button>
  <br><br>
  <div class="well well-lg">
    <p>You can also make your payment using a Demand Draft of INR 350 in favour of "IIIT-Delhi Collections Account" payable at "Delhi" to the following address:<br>
    Assistant Manager (Academics)<br>
    A-109, Academics Building, IIIT-Delhi<br>
    Okhla Industrial Estate, Phase-3<br>
    New Delhi - 110020<br>
    Please fill in the details of your demand draft in the following form.</p>
  </div>
    <div class="checkbox">
      <label><input type="checkbox" id="dd" name="dd" value="true">Will you be paying through Demand Draft</label>
    </div>
    <br>
    <div id="ddContent" style="display:none">
      <div class="form-group">
        <label class="control-label col-sm-2" >Bank Name*</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="bankName" name="bankName">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" >Branch*</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="bankBranch" name="bankBranch">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" >Demand Draft No.*</label>
        <div class="col-sm-4">
          <input type="number" class="form-control" id="ddNumber" name="ddNumber">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-4">
        <% if(session.getAttribute("payment").equals("1")) { %>
          <button type="submit" class="btn btn-default" disabled>Save</button>
          <% } else { %>
          <button type="submit" class="btn btn-default">Save</button>
          <% } %>
        </div>
      </div>
      <br>
    </div>

  </form>
</div>