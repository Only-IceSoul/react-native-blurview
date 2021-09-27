//
//  BlurRoot.swift
//  react-native-blurview
//
//  Created by Juan J LF on 9/26/21.
//

import Foundation

import UIKit


@objc(BlurRootView)
class BlurRootView: RCTView {
    
    
    init() {
        super.init(frame: .zero)
    }
    
      @objc func setName(_ v:NSString?){
      }
     
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
        
    }

}
