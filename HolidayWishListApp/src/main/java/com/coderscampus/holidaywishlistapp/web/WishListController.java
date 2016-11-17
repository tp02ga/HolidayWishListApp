package com.coderscampus.holidaywishlistapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderscampus.holidaywishlistapp.domain.Family;
import com.coderscampus.holidaywishlistapp.domain.FamilyMember;
import com.coderscampus.holidaywishlistapp.domain.Gift;
import com.coderscampus.holidaywishlistapp.repositories.FamilyMemberRepository;
import com.coderscampus.holidaywishlistapp.repositories.GiftRepository;

@Controller
public class WishListController
{
  @Autowired
  private FamilyMemberRepository familyMemberRepo;
  @Autowired
  private GiftRepository giftRepo;
  
  @RequestMapping(value="/family", method=RequestMethod.GET)
  public String family (@AuthenticationPrincipal FamilyMember user, ModelMap model) 
  {
    Family family = user.getFamily();
    
    model.put("family", family);
    
    return "family";  // the view (i.e. the html page... it'll look for family.html)
  }
  
  @RequestMapping(value="/family/familyMember/{familyMemberId}", method=RequestMethod.GET)
  public String familyMember (@AuthenticationPrincipal FamilyMember user, 
      @PathVariable Long familyMemberId, ModelMap model) 
  {
    FamilyMember familyMember = familyMemberRepo.findOne(familyMemberId);
    
    model.put("isThisMe", user.getId().equals(familyMember.getId()));
    model.put("familyMember", familyMember);
    
    return "familyMember";
  }
  
  @RequestMapping(value="/family/familyMember/{familyMemberId}/gifts", method=RequestMethod.GET)
  public String addGift (@AuthenticationPrincipal FamilyMember user, 
      @PathVariable Long familyMemberId, ModelMap model) 
  {
    FamilyMember familyMember = familyMemberRepo.findOne(familyMemberId);
    
    Gift gift = new Gift();
    
    model.put("gift", gift);
    model.put("familyMember", familyMember);
    
    return "gift";
  }
  
  @RequestMapping(value="/family/familyMember/{familyMemberId}/gifts", method=RequestMethod.POST)
  public String addNewGift (@ModelAttribute Gift gift, @AuthenticationPrincipal FamilyMember user, 
      @PathVariable Long familyMemberId, ModelMap model) 
  {
    FamilyMember familyMember = familyMemberRepo.findOne(familyMemberId);
    
    familyMember.getGifts().add(gift);
    gift.setFamilyMember(familyMember);
    giftRepo.save(gift);
    
    return "redirect:/family/familyMember/" + familyMember.getId();
  }
  
  @RequestMapping(value="/family/familyMember/{familyMemberId}/gifts/{giftId}/dibs", method=RequestMethod.GET)
  public String addGift (@AuthenticationPrincipal FamilyMember user, @PathVariable Long giftId,
      @PathVariable Long familyMemberId, ModelMap model) 
  {
    Gift gift = giftRepo.findOne(giftId);
    
    gift.setDibsName(user.getName());
    
    giftRepo.save(gift);
    
    return "redirect:/family/familyMember/" + familyMemberId;
  }
  
}
