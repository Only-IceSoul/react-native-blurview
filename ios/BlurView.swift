//
//  Blur.swift
//  react-native-blurview
//
//  Created by Juan J LF on 9/26/21.
//

import Foundation

import UIKit


@objc(BlurView)
class BlurView: UIView {
    
    
   var mBlurEffect = VisualEffectView()
    

    init() {
        super.init(frame: .zero)
        mBlurEffect.blurRadius = 24
        mBlurEffect.overlayView?.removeFromSuperview()
        addSubview(mBlurEffect)
    }

   
 
  
    @objc func setBlurNode(_ v:NSString?){
    }
   
    
   

   
    
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
        
    }

}
