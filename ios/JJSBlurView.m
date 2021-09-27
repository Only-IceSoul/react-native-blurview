//
//  BlurView.m
//  react-native-blurview
//
//  Created by Juan J LF on 9/26/21.
//


#import <Foundation/Foundation.h>
#import "React/RCTViewManager.h"
#import <React/RCTBridgeModule.h>
#import <UIKit/UIKit.h>


@interface
RCT_EXTERN_MODULE(JJSBlurView,RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(blurNode, NSString)


@end
