

   
    <option selected="selected">Choisir l'hopital :</option>
     <c:forEach items="${hopitalArray}" var="hopital">
     
     <option value="${hopital.getNum_hopital() }">${hopital.getNom() }</option>
     </c:forEach>
     
     