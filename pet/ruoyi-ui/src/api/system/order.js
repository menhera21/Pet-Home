import request from '@/utils/request'

// 查询宠物寄养订单，记录宠物寄养的相关信息列表
export function listOrder(query) {
  return request({
    url: '/system/order/list',
    method: 'get',
    params: query
  })
}

// 查询宠物寄养订单，记录宠物寄养的相关信息详细
export function getOrder(fosterId) {
  return request({
    url: '/system/order/' + fosterId,
    method: 'get'
  })
}

// 新增宠物寄养订单，记录宠物寄养的相关信息
export function addOrder(data) {
  return request({
    url: '/system/order',
    method: 'post',
    data: data
  })
}

// 修改宠物寄养订单，记录宠物寄养的相关信息
export function updateOrder(data) {
  return request({
    url: '/system/order',
    method: 'put',
    data: data
  })
}

// 删除宠物寄养订单，记录宠物寄养的相关信息
export function delOrder(fosterId) {
  return request({
    url: '/system/order/' + fosterId,
    method: 'delete'
  })
}
