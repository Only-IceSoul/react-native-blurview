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
        mBlurEffect.blurRadius = 10
        mBlurEffect.overlayView?.removeFromSuperview()
        addSubview(mBlurEffect)
    }

    override var bounds: CGRect{
        didSet{
            mBlurEffect.frame = bounds
        }
    }
 
    
    override var backgroundColor: UIColor?{
        set{
            super.backgroundColor = nil
        }
        get{
            super.backgroundColor
        }
    }
  
    @objc func setBlurNode(_ v:NSString?){
    }
   
    
      @objc func setRadius(_ v:NSNumber?){
        let ev = v == nil ? 10 : CGFloat(truncating: v!)
        mBlurEffect.blurRadius = ev
      }
     
   

   
    
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
        
    }

}
